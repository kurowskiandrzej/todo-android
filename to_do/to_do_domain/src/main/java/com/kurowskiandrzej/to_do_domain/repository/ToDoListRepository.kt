package com.kurowskiandrzej.to_do_domain.repository

import com.kurowskiandrzej.to_do_domain.model.ToDoList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

interface ToDoListRepository {

    suspend fun fetchData(dispatcher: CoroutineDispatcher, token: String): Result<Unit>

    fun observeToDoLists(): Flow<List<ToDoList>>

    suspend fun postToDoList(toDoListName: String): Result<Unit>
}