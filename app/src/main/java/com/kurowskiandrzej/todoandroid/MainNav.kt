package com.kurowskiandrzej.todoandroid

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kurowskiandrzej.auth_presentation.login.LoginScreen
import com.kurowskiandrzej.auth_presentation.register.RegisterScreen
import com.kurowskiandrzej.core.navigation.Route
import com.kurowskiandrzej.to_do_presentation.nav.ToDoNav
import com.kurowskiandrzej.to_do_presentation.view.to_do_lists.ToDoListsScreen

@Composable
fun MainNav(
    isUserAuthenticated: Boolean,
    onLoginSuccess: () -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = if (isUserAuthenticated) Route.TODO_NAV else Route.LOGIN
    ) {
        composable(Route.LOGIN) {
            LoginScreen(
                navController = navController,
                onLoginSuccess = onLoginSuccess
            )
        }

        composable(Route.REGISTER) {
            RegisterScreen(
                navController = navController
            )
        }

        composable(Route.TODO_NAV) {
            ToDoNav()
        }
    }
}