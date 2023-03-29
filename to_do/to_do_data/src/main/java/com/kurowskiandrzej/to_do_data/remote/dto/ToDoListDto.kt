package com.kurowskiandrzej.to_do_data.remote.dto

import com.squareup.moshi.Json

data class ToDoListDto(
    @field:Json(name = "list_id")
    val id: Long,
    val name: String,
    @field:Json(name = "created")
    val createdAt: String
)
