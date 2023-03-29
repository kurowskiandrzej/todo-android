package com.kurowskiandrzej.app_database.entity.to_do_list

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ToDoList")
data class ToDoListEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val createdAt: String
)
