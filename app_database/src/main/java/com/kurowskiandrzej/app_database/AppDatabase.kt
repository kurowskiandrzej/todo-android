package com.kurowskiandrzej.app_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kurowskiandrzej.app_database.dao.ToDoListDao
import com.kurowskiandrzej.app_database.dao.ToDoTaskDao
import com.kurowskiandrzej.app_database.entity.to_do_list.ToDoListEntity
import com.kurowskiandrzej.app_database.entity.to_do_task.ToDoTaskEntity

@Database(
    entities = [
        ToDoListEntity::class,
        ToDoTaskEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract val toDoListDao: ToDoListDao

    abstract val toDoTaskDao: ToDoTaskDao

    companion object {
        const val DB_NAME = "to_do_database"
    }
}