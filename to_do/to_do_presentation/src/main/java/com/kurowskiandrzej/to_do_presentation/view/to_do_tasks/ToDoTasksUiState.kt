package com.kurowskiandrzej.to_do_presentation.view.to_do_tasks

import com.kurowskiandrzej.to_do_domain.model.ToDoTask

data class ToDoTasksUiState(
    val toDoTasks: List<ToDoTask> = listOf(),
    val myLong: Long = 0L
)