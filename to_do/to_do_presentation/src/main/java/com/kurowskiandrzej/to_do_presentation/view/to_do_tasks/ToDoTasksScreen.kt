package com.kurowskiandrzej.to_do_presentation.view.to_do_tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kurowskiandrzej.to_do_domain.model.ToDoTask

@Composable
fun ToDoTasksScreen(
    viewModel: ToDoTasksViewModel = hiltViewModel()
) {
    val state = viewModel.state

    ToDoTasksContent(
        toDoTasks = state.toDoTasks
    )
}

@Composable
private fun ToDoTasksContent(
    toDoTasks: List<ToDoTask>
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(toDoTasks.size) { position ->
                Text(text = toDoTasks[position].value)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}