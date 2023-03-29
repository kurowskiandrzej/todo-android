package com.kurowskiandrzej.to_do_presentation.view.to_do_lists

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kurowskiandrzej.core_ui.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoListsViewModel @Inject constructor(
    private val useCases: ToDoListsUseCases
) : ViewModel() {

    var state by mutableStateOf(ToDoListsUiState())
        private set

    init {
        observeToDoLists()
    }

    fun onEvent(event: ToDoListsUiEvent) {
        when (event) {
            is ToDoListsUiEvent.OnNewToDoListNameInput -> {
                state = state.copy(
                    newToDoListName = event.newToDoListNameInput,
                    isCreateNewToDoListButtonEnabled = useCases.validateToDoListName(
                        toDoListName = event.newToDoListNameInput
                    )
                )
            }

            is ToDoListsUiEvent.OnCreateNewToDoListClick -> {
                postToDoList(state.newToDoListName)
            }
        }
    }

    private fun observeToDoLists() {
        viewModelScope.launch {
            useCases.observeToDoLists().collect { toDoLists ->
                state = state.copy(
                    toDoLists = toDoLists.sortedBy { it.id }
                )
            }
        }
    }

    private fun postToDoList(toDoListName: String) {
        viewModelScope.launch {
            showLoading()

            val postToDoListResult = useCases.postToDoList(
                toDoListName = toDoListName
            )

            if (postToDoListResult.isSuccess) {
                state = state.copy(
                    newToDoListName = ""
                )
            } else {
                val exception = postToDoListResult.exceptionOrNull()

                exception?.let {

                }
            }

            hideLoading()
        }
    }

    private fun hideLoading() {
        state = state.copy(
            isCreateNewToDoListButtonEnabled = true,
            isLoading = false
        )
    }

    private fun showLoading() {
        state = state.copy(
            isCreateNewToDoListButtonEnabled = false,
            isLoading = true
        )
    }
}