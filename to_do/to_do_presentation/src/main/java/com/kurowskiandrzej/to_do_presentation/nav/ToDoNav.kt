package com.kurowskiandrzej.to_do_presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kurowskiandrzej.core.navigation.Route
import com.kurowskiandrzej.to_do_presentation.view.to_do_lists.ToDoListsScreen
import com.kurowskiandrzej.to_do_presentation.view.to_do_tasks.ToDoTasksScreen

@Composable
fun ToDoNav() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.TODO_LISTS
    ) {
        composable(Route.TODO_LISTS) {
            ToDoListsScreen(navController = navController)
        }

        composable(
            route = Route.TODO_TASKS + "/{${Route.TO_DO_LIST_ID_KEY}}",
            arguments = listOf(navArgument(Route.TO_DO_LIST_ID_KEY) { type = NavType.LongType })
        ) {
            ToDoTasksScreen()
        }
    }
}