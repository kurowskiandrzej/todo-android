package com.kurowskiandrzej.to_do_presentation.view.to_do_tasks

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kurowskiandrzej.core.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoTasksViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCases: ToDoTasksUseCases
) : ViewModel() {

    var state by mutableStateOf(ToDoTasksUiState())
        private set

    init {
        val toDoListId = savedStateHandle.get<Long>(Route.TO_DO_LIST_ID_KEY)!!
        observeToDoTasks(toDoListId)
    }

    private fun observeToDoTasks(listId: Long) {
        viewModelScope.launch {
            useCases.observeToDoTasks(listId).collect { toDoTasks ->
                state = state.copy(
                    toDoTasks = toDoTasks
                )
            }
        }
    }
}