package com.kurowskiandrzej.to_do_data.repository

import com.kurowskiandrzej.app_database.dao.ToDoListDao
import com.kurowskiandrzej.app_database.dao.ToDoTaskDao
import com.kurowskiandrzej.app_database.entity.to_do_list.ToDoListEntity
import com.kurowskiandrzej.core.data.remote.api_call_handler.apiCall
import com.kurowskiandrzej.core.domain.preferences.AuthPreferences
import com.kurowskiandrzej.to_do_data.mapper.toToDoListEntity
import com.kurowskiandrzej.to_do_data.mapper.toToDoListEntityList
import com.kurowskiandrzej.to_do_data.mapper.toToDoTaskEntityList
import com.kurowskiandrzej.to_do_data.remote.ToDoListApi
import com.kurowskiandrzej.to_do_data.remote.ToDoTaskApi
import com.kurowskiandrzej.to_do_domain.model.ToDoList
import com.kurowskiandrzej.to_do_domain.repository.ToDoListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToDoListRepositoryImpl @Inject constructor(
    private val toDoListApi: ToDoListApi,
    private val toDoTaskApi: ToDoTaskApi,
    private val toDoListDao: ToDoListDao,
    private val toDoTaskDao: ToDoTaskDao,
    private val authPreferences: AuthPreferences
) : ToDoListRepository {

    override suspend fun fetchData(
        dispatcher: CoroutineDispatcher,
        token: String
    ): Result<Unit> {
        val fetchListsResponse = withContext(dispatcher) {
            apiCall {
                toDoListApi.fetchTodoLists(token = token)
            }
        }

        val lists = fetchListsResponse
            .getOrElse { exception -> return Result.failure(exception) }
            .lists

        val fetchTasksResponses = withContext(dispatcher) {
            lists.map { list ->
                async {
                    apiCall {
                        toDoTaskApi.fetchTasksByListId(
                            token = token,
                            listId = list.id
                        )
                    }
                }
            }.awaitAll()
        }

        val tasks = fetchTasksResponses
            .map { it.getOrElse { exception -> return Result.failure(exception) } }
            .flatMap { it.tasks }

        toDoListDao.deleteAllLists()
        toDoListDao.insertLists(
            lists = lists.toToDoListEntityList()
        )
        toDoTaskDao.insertTasks(
            tasks = tasks.toToDoTaskEntityList()
        )

        return Result.success(Unit)
    }

    override fun observeToDoLists(): Flow<List<ToDoList>> {
        return toDoListDao.observeToDoLists()
    }

    override suspend fun postToDoList(toDoListName: String): Result<Unit> {
        val token = authPreferences.getAccessToken()
            ?: return Result.failure(Exception("Missing token"))

        val postToDoListResult = apiCall {
            toDoListApi.postToDoList(
                token = token,
                toDoListName = mapOf("list_name" to toDoListName)
            )
        }

        if (postToDoListResult.isFailure) {
            return postToDoListResult.map {  }
        }

        val newToDoList = postToDoListResult.getOrElse { exception ->
            return Result.failure(exception)
        }

        toDoListDao.insertLists(
            listOf(
                newToDoList.toToDoListEntity()
            )
        )

        return Result.success(Unit)
    }
}