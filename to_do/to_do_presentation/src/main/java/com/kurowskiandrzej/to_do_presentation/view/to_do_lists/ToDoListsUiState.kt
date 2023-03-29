package com.kurowskiandrzej.to_do_presentation.view.to_do_lists

import com.kurowskiandrzej.to_do_domain.model.ToDoList

data class ToDoListsUiState(
    val toDoLists: List<ToDoList> = listOf(),
    val newToDoListName: String = "",
    val isCreateNewToDoListButtonEnabled: Boolean = false,
    val isLoading: Boolean = false
)
