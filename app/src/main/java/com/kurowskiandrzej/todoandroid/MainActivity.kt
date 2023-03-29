package com.kurowskiandrzej.todoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.kurowskiandrzej.core_ui.ui.theme.ToDoAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ToDoAndroidTheme {
                MainNav(
                    isUserAuthenticated = viewModel.isUserAuthenticated,
                    onLoginSuccess = viewModel::fetchData
                )
            }
        }
    }
}