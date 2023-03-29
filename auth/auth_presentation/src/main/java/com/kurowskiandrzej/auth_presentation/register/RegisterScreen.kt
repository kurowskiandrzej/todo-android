package com.kurowskiandrzej.auth_presentation.register

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
import com.kurowskiandrzej.auth_presentation.register.components.RegisterFormView
import com.kurowskiandrzej.core.navigation.Route
import com.kurowskiandrzej.core_ui.ui.theme.ToDoAndroidTheme
import com.kurowskiandrzej.core_ui.ui.theme.spacing
import com.kurowskiandrzej.core_ui.util.DevicePreviews
import com.kurowskiandrzej.core_ui.util.DeviceScreenType
import com.kurowskiandrzej.core_ui.util.rememberDeviceScreenInfo

@Composable
fun RegisterScreen(
    navController: NavHostController,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {
    val state = registerViewModel.state

    RegisterScreenContent(
        state = state,
        onEmailInput = { emailInput ->
            registerViewModel.onEvent(
                event = RegisterUiEvent.OnEmailInput(emailInput)
            )
        },
        onPasswordInput = { passwordInput ->
            registerViewModel.onEvent(
                event = RegisterUiEvent.OnPasswordInput(passwordInput)
            )
        },
        onPasswordConfirmationInput = { passwordConfirmationInput ->
            registerViewModel.onEvent(
                event = RegisterUiEvent.OnPasswordConfirmationInput(passwordConfirmationInput)
            )
        },
        onRegisterClick = {
            registerViewModel.onEvent(
                event = RegisterUiEvent.OnRegisterClick(
                    onSuccess = { navController.navigate(Route.AUTH_EXIT) }
                )
            )
        },
        togglePasswordVisibility = {
            registerViewModel.onEvent(
                event = RegisterUiEvent.TogglePasswordVisibility
            )
        },
        navigateToLogin = {
            navController.navigate(Route.LOGIN) {
                popUpTo(Route.LOGIN)
                launchSingleTop = true
            }
        }
    )

}

@Composable
private fun RegisterScreenContent(
    state: RegisterUiState,
    onEmailInput: (emailInput: String) -> Unit,
    onPasswordInput: (passwordInput: String) -> Unit,
    onPasswordConfirmationInput: (passwordConfirmationInput: String) -> Unit,
    onRegisterClick: () -> Unit,
    togglePasswordVisibility: () -> Unit,
    navigateToLogin: () -> Unit
) {
    val deviceScreenInfo = rememberDeviceScreenInfo()

    val registerFormView: @Composable (
        modifier: Modifier,
        showAppName: Boolean,
    ) -> Unit = { modifier, showAppName ->
        RegisterFormView(
            modifier = modifier,
            state = state,
            onEmailInput = onEmailInput,
            onPasswordInput = onPasswordInput,
            onPasswordConfirmationInput = onPasswordConfirmationInput,
            onRegisterClick = onRegisterClick,
            isPasswordVisible = state.isPasswordVisible,
            showAppName = showAppName,
            togglePasswordVisibility = togglePasswordVisibility,
            navigateToLogin = navigateToLogin
        )
    }

    when (deviceScreenInfo.screenWidthInfo) {
        is DeviceScreenType.Compact -> {
            registerFormView(
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

                registerFormView(
                    modifier = Modifier.weight(1f),
                    showAppName = false
                )
            }
        }
    }
}

@DevicePreviews
@Composable
fun RegisterScreenPreview() {
    ToDoAndroidTheme {
        RegisterScreenContent(
            state = RegisterUiState(
                passwordInput = "MyPass",
                isPasswordVisible = false,
            ),
            onEmailInput = {},
            onPasswordInput = {},
            onPasswordConfirmationInput = {},
            onRegisterClick = {},
            togglePasswordVisibility = {},
            navigateToLogin = {}
        )
    }
}