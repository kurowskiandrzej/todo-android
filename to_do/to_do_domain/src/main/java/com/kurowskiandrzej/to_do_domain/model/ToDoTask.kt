package com.kurowskiandrzej.to_do_domain.model

data class ToDoTask(
    val id: Long,
    val listId: Long,
    val value: String,
    val isCompleted: Boolean,
    val createdAt: String,
    val completedOn: String?
)
