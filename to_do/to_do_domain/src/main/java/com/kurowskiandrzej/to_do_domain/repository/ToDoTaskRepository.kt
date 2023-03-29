package com.kurowskiandrzej.to_do_domain.repository

import com.kurowskiandrzej.to_do_domain.model.ToDoTask
import kotlinx.coroutines.flow.Flow

interface ToDoTaskRepository {

    suspend fun downloadTasks(token: String, listId: Long)

    fun observeTasksByListId(listId: Long): Flow<List<ToDoTask>>
}