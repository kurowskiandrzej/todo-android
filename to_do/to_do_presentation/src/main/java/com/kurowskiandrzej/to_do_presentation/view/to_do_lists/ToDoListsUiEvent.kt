package com.kurowskiandrzej.to_do_presentation.view.to_do_lists

sealed interface ToDoListsUiEvent {

    data class OnNewToDoListNameInput(val newToDoListNameInput: String) : ToDoListsUiEvent

    object OnCreateNewToDoListClick : ToDoListsUiEvent
}