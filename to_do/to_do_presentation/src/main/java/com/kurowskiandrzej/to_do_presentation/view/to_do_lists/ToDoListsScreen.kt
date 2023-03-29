package com.kurowskiandrzej.to_do_presentation.view.to_do_lists

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kurowskiandrzej.core.navigation.Route
import com.kurowskiandrzej.core_ui.ui.theme.ToDoAndroidTheme
import com.kurowskiandrzej.core_ui.ui.theme.spacing
import com.kurowskiandrzej.core_ui.util.DevicePreviews
import com.kurowskiandrzej.to_do_domain.model.ToDoList
import com.kurowskiandrzej.to_do_presentation.components.InputView
import com.kurowskiandrzej.to_do_presentation.components.ToDoItemView

@Composable
fun ToDoListsScreen(
    viewModel: ToDoListsViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state

    ToDoListsScreenContent(
        state = state,
        onNewToDoListNameInput = { newToDoListNameInput ->
            viewModel.onEvent(
                event = ToDoListsUiEvent.OnNewToDoListNameInput(newToDoListNameInput)
            )
        },
        onToDoListItemClick = { listId ->
            navController.navigate(
                Route.build(route = Route.TODO_TASKS, listId)
            )
        },
        onCreateNewToDoListClick = {
            viewModel.onEvent(
                event = ToDoListsUiEvent.OnCreateNewToDoListClick
            )
        }
    )
}

@Composable
private fun ToDoListsScreenContent(
    state: ToDoListsUiState,
    onNewToDoListNameInput: (newToDoListNameInput: String) -> Unit,
    onToDoListItemClick: (listId: Long) -> Unit,
    onCreateNewToDoListClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        InputView(
            input = state.newToDoListName,
            onInput = onNewToDoListNameInput,
            placeholderText = "",
            onSubmitClick = onCreateNewToDoListClick,
            enabled = state.isCreateNewToDoListButtonEnabled,
            showProgressBar = false
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.spaceSmall))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spaceSmall)
        ) {
            items(state.toDoLists.size) { position ->
                ToDoItemView {
                    Text(
                        modifier = Modifier
                            .padding(MaterialTheme.spacing.spaceSmall)
                            .weight(1f),
                        text = state.toDoLists[position].name
                    )
                    Text(
                        modifier = Modifier
                            .padding(MaterialTheme.spacing.spaceSmall),
                        text = composeTaskCounterString(
                            numberOfCompletedTasks = state.toDoLists[position].numberOfFinishedTasks,
                            numberOfAllTasks = state.toDoLists[position].numberOfAllTasks
                        )
                    )
                }
            }
        }
    }
}

@DevicePreviews
@Composable
fun ToDoListsScreenPreview() {
    ToDoAndroidTheme {
        ToDoListsScreenContent(
            ToDoListsUiState(
                toDoLists = getStubs(),
                newToDoListName = "New List"
            ),
            onNewToDoListNameInput = { },
            onToDoListItemClick = { },
            onCreateNewToDoListClick = { }
        )
    }
}

private fun composeTaskCounterString(
    numberOfCompletedTasks: Int,
    numberOfAllTasks: Int
): String {
    return "$numberOfCompletedTasks/$numberOfAllTasks"
}

private fun getStubs(): List<ToDoList> {
    return listOf(
        ToDoList(
            id = 0,
            name = "first list",
            createdAt = "10-10-2022",
            numberOfFinishedTasks = 0,
            numberOfAllTasks = 1
        ),
        ToDoList(
            id = 0,
            name = "second list",
            createdAt = "10-10-2022",
            numberOfFinishedTasks = 0,
            numberOfAllTasks = 1
        ),
        ToDoList(
            id = 0,
            name = "third list",
            createdAt = "10-10-2022",
            numberOfFinishedTasks = 0,
            numberOfAllTasks = 1
        )
    )
}