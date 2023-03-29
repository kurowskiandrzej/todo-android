package com.kurowskiandrzej.app_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kurowskiandrzej.app_database.entity.to_do_task.ToDoTaskEntity
import com.kurowskiandrzej.to_do_domain.model.ToDoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoTaskDao {

    @Insert
    suspend fun insertTasks(tasks: List<ToDoTaskEntity>)

    @Query(
        """
        SELECT * FROM ToDoTask
        WHERE listId = :listId
        """
    )
    fun observeTasksByListId(listId: Long): Flow<List<ToDoTask>>
}