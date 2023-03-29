package com.kurowskiandrzej.auth_presentation.login.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kurowskiandrzej.auth_presentation.R
import com.kurowskiandrzej.auth_presentation.login.LoginUiState
import com.kurowskiandrzej.core_ui.components.buttons.ActionButton
import com.kurowskiandrzej.core_ui.ui.theme.ToDoAndroidTheme
import com.kurowskiandrzej.core_ui.ui.theme.spacing

@Composable
fun LoginFormView(
    modifier: Modifier = Modifier,
    state: LoginUiState,
    onEmailInput: (emailInput: String) -> Unit,
    onPasswordInput: (passwordInput: String) -> Unit,
    onLoginClick: () -> Unit,
    isPasswordVisible: Boolean,
    showAppName: Boolean,
    togglePasswordVisibility: () -> Unit,
    navigateToRegister: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(
            space = MaterialTheme.spacing.spaceSmall,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showAppName) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onBackground
            )
        }

        TextField(
            label = { Text(text = stringResource(id = R.string.email)) },
            singleLine = true,
            value = state.emailInput,
            isError = state.emailValidationErrorMessage != null,
            onValueChange = { emailInput -> onEmailInput(emailInput) },
            enabled = !state.isLoading
        )

        if (state.emailValidationErrorMessage != null) {
            Text(
                text = state.emailValidationErrorMessage.asString(),
                color = MaterialTheme.colors.error
            )
        }

        TextField(
            label = { Text(text = stringResource(id = R.string.password)) },
            singleLine = true,
            value = state.passwordInput,
            isError = state.passwordValidationErrorMessage != null,
            onValueChange = { passwordInput -> onPasswordInput(passwordInput) },
            enabled = !state.isLoading,
            visualTransformation = if (isPasswordVisible) {
                VisualTransformation.None
            } else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (isPasswordVisible) Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                val description = if (isPasswordVisible) {
                    stringResource(id = R.string.hide_password)
                } else stringResource(id = R.string.show_password)

                IconButton(onClick = togglePasswordVisibility) {
                    Icon(
                        imageVector = image,
                        contentDescription = description
                    )
                }
            }
        )

        if (state.passwordValidationErrorMessage != null) {
            Text(
                text = state.passwordValidationErrorMessage.asString(),
                color = MaterialTheme.colors.error
            )
        }

        ActionButton(
            text = stringResource(id = R.string.login),
            onClick = onLoginClick,
            enabled = !state.isLoading,
            showProgressBar = state.isLoading
        )

        TextButton(onClick = navigateToRegister) {
            Text(text = stringResource(id = R.string.go_to_register))
        }
    }
}

@Preview(
    name = "phone",
    device = "spec:width=360dp,height=640dp,dpi=480",
    showBackground = true
)
@Preview(
    name = "phone_dark_mode",
    device = "spec:width=360dp,height=640dp,dpi=480",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun LoginFormPreview() {
    ToDoAndroidTheme {
        LoginFormView(
            state = LoginUiState(),
            onEmailInput = {},
            onPasswordInput = {},
            onLoginClick = {},
            isPasswordVisible = false,
            showAppName = true,
            togglePasswordVisibility = {},
            navigateToRegister = {}
        )
    }
}