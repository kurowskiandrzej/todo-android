package com.kurowskiandrzej.app_database.entity.to_do_task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.kurowskiandrzej.app_database.entity.to_do_list.ToDoListEntity

@Entity(
    tableName = "ToDoTask",
    foreignKeys = [
        ForeignKey(
            entity = ToDoListEntity::class,
            parentColumns = ["id"],
            childColumns = ["listId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ToDoTaskEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(index = true)
    val listId: Long,
    val value: String,
    val isCompleted: Boolean,
    val createdAt: String,
    val completedOn: String?
)