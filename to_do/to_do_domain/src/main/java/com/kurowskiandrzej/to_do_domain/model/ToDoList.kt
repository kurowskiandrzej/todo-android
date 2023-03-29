package com.kurowskiandrzej.to_do_domain.model

data class ToDoList(
    val id: Long,
    val name: String,
    val createdAt: String,
    val numberOfFinishedTasks: Int,
    val numberOfAllTasks: Int
)
