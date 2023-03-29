package com.kurowskiandrzej.auth_presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kurowskiandrzej.auth_presentation.components.AuthLandingPageView
import com.kurowskiandrzej.auth_presentation.login.components.LoginFormView
import com.kurowskiandrzej.core.navigation.Route
import com.kurowskiandrzej.core_ui.ui.theme.ToDoAndroidTheme
import com.kurowskiandrzej.core_ui.ui.theme.spacing
import com.kurowskiandrzej.core_ui.util.DevicePreviews
import com.kurowskiandrzej.core_ui.util.DeviceScreenType
import com.kurowskiandrzej.core_ui.util.rememberDeviceScreenInfo

@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    onLoginSuccess: () -> Unit
) {
    val state = loginViewModel.state

    LoginScreenContent(
        state = state,
        onEmailInput = { emailInput ->
            loginViewModel.onEvent(
                event = LoginUiEvent.OnEmailInput(emailInput)
            )
        },
        onPasswordInput = { passwordInput ->
            loginViewModel.onEvent(
                event = LoginUiEvent.OnPasswordInput(passwordInput)
            )
        },
        onLoginClick = {
            loginViewModel.onEvent(
                event = LoginUiEvent.OnLoginClick(
                    onSuccess = {
                        onLoginSuccess()
                        navController.navigate(Route.AUTH_EXIT) {
                            popUpTo(Route.LOGIN) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                )
            )
        },
        togglePasswordVisibility = {
            loginViewModel.onEvent(
                LoginUiEvent.TogglePasswordVisibility
            )
        },
        navigateToRegister = {
            navController.navigate(Route.REGISTER) {
                popUpTo(Route.REGISTER)
                launchSingleTop = true
            }
        }
    )
}

@Composable
fun LoginScreenContent(
    state: LoginUiState,
    onEmailInput: (emailInput: String) -> Unit,
    onPasswordInput: (passwordInput: String) -> Unit,
    onLoginClick: () -> Unit,
    togglePasswordVisibility: () -> Unit,
    navigateToRegister: () -> Unit,
) {
    val deviceScreenInfo = rememberDeviceScreenInfo()

    val loginFormView: @Composable (
        modifier: Modifier,
        showAppName: Boolean
    ) -> Unit = { modifier, showAppName ->
        LoginFormView(
            modifier = modifier,
            state = state,
            onEmailInput = onEmailInput,
            onPasswordInput = onPasswordInput,
            onLoginClick = onLoginClick,
            isPasswordVisible = state.isPasswordVisible,
            showAppName = showAppName,
            togglePasswordVisibility = togglePasswordVisibility,
            navigateToRegister = navigateToRegister
        )
    }

    when (deviceScreenInfo.screenWidthInfo) {
        is DeviceScreenType.Compact -> {
            loginFormView(
                modifier = Modifier,
                showAppName = true
            )
        }

        is DeviceScreenType.Medium,
        DeviceScreenType.Expanded,
        DeviceScreenType.Foldable -> {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
            ) {
                AuthLandingPageView(modifier = Modifier.weight(1f))

                Divider(Modifier.width(MaterialTheme.spacing.spaceMedium))

                loginFormView(
                    modifier = Modifier.weight(1f),
                    showAppName = false
                )
            }
        }
    }
}

@DevicePreviews
@Composable
fun LoginScreenPreview() {
    ToDoAndroidTheme {
        LoginScreenContent(
            state = LoginUiState(
                passwordInput = "MyPass",
                isPasswordVisible = false,
            ),
            onEmailInput = {},
            onPasswordInput = {},
            onLoginClick = {},
            togglePasswordVisibility = {},
            navigateToRegister = {}
        )
    }
}