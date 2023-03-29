package com.kurowskiandrzej.to_do_data.remote.dto

import com.squareup.moshi.Json

data class ToDoTaskDto(
    val id: Long,
    @field:Json(name = "list_id")
    val listId: Long,
    val value: String,
    @field:Json(name = "is_completed")
    val isCompleted: Boolean,
    @field:Json(name = "created_on")
    val createdAt: String,
    @field:Json(name = "completed_on")
    val completedOn: String?
)
