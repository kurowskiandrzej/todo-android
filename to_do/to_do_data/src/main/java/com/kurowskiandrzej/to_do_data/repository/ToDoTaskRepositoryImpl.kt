package com.kurowskiandrzej.to_do_data.repository

import com.kurowskiandrzej.app_database.dao.ToDoTaskDao
import com.kurowskiandrzej.to_do_data.remote.ToDoTaskApi
import com.kurowskiandrzej.to_do_domain.model.ToDoTask
import com.kurowskiandrzej.to_do_domain.repository.ToDoTaskRepository
import kotlinx.coroutines.flow.Flow

class ToDoTaskRepositoryImpl(
    private val toDoTaskApi: ToDoTaskApi,
    private val toDoTaskDao: ToDoTaskDao
) : ToDoTaskRepository {

    override suspend fun downloadTasks(token: String, listId: Long) {
        toDoTaskApi.fetchTasksByListId(
            token = token,
            listId = listId
        )
    }

    override fun observeTasksByListId(listId: Long): Flow<List<ToDoTask>> {
        return toDoTaskDao.observeTasksByListId(listId)
    }
}