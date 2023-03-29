package com.kurowskiandrzej.app_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kurowskiandrzej.app_database.entity.to_do_list.ToDoListEntity
import com.kurowskiandrzej.to_do_domain.model.ToDoList
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoListDao {

    @Insert
    suspend fun insertLists(lists: List<ToDoListEntity>)

    @Query(
        """
        SELECT
            ToDoList.id,
            ToDoList.name,
            ToDoList.createdAt,
            COUNT(
                CASE WHEN ToDoTask.isCompleted = 1 
                THEN ToDoTask.id 
                ELSE NULL 
                END) AS 'numberOfFinishedTasks',
            COUNT(ToDoTask.id) AS 'numberOfAllTasks'
        FROM ToDoList
        LEFT JOIN ToDoTask
        ON ToDoList.id = ToDoTask.listId
        GROUP BY ToDoList.id
        """
    )
    fun observeToDoLists(): Flow<List<ToDoList>>

    @Query("DELETE FROM ToDoList")
    suspend fun deleteAllLists()
}