package com.kurowskiandrzej.auth_presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kurowskiandrzej.auth_presentation.R
import com.kurowskiandrzej.core_ui.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val useCases: RegisterUseCases
) : ViewModel() {

    var state by mutableStateOf(RegisterUiState())
        private set

    fun onEvent(event: RegisterUiEvent) {
        when (event) {
            is RegisterUiEvent.OnEmailInput -> {
                state = state.copy(emailInput = event.emailInput)
                if (state.shouldValidateOnInput) validateInputs()
            }

            is RegisterUiEvent.OnPasswordInput -> {
                state = state.copy(passwordInput = event.passwordInput)
                if (state.shouldValidateOnInput) validateInputs()
            }

            is RegisterUiEvent.OnPasswordConfirmationInput -> {
                state = state.copy(passwordConfirmationInput = event.passwordConfirmationInput)
                if (state.shouldValidateOnInput) validateInputs()
            }

            is RegisterUiEvent.OnRegisterClick -> {
                onRegisterClick(onSuccess = event.onSuccess)
            }

            is RegisterUiEvent.TogglePasswordVisibility -> {
                state = state.copy(isPasswordVisible = !state.isPasswordVisible)
            }
        }
    }

    private fun onRegisterClick(onSuccess: () -> Unit) {
        viewModelScope.launch {
            showLoading()

            val areInputsValid = validateInputs()
            if (!areInputsValid) {
                hideLoading()
                return@launch
            }

            val registerResult = useCases.registerUser(
                email = state.emailInput,
                password = state.passwordInput
            )

            registerResult.onFailure {
                val errorMessage = UiText.orUnknownError(message = it.message)

                state = state.copy(
                    passwordValidationErrorMessage = errorMessage
                )
                hideLoading()
                return@launch
            }

            onSuccess()
        }
    }

    private fun validateInputs(): Boolean {
        state = state.copy(
            emailValidationErrorMessage = null,
            passwordValidationErrorMessage = null
        )

        if (state.emailInput.isEmpty()) {
            state = state.copy(
                emailValidationErrorMessage = UiText.ResourceId(R.string.empty_email),
                shouldValidateOnInput = true
            )
        } else if (!useCases.validateEmail(state.emailInput)) {
            state = state.copy(
                emailValidationErrorMessage = UiText.ResourceId(R.string.invalid_email),
                shouldValidateOnInput = true
            )
        }

        if (state.passwordInput.isEmpty()) {
            state = state.copy(
                passwordValidationErrorMessage = UiText.ResourceId(R.string.empty_password),
                shouldValidateOnInput = true
            )
        }

        return state.emailValidationErrorMessage == null
                && state.passwordValidationErrorMessage == null
    }

    private fun hideLoading() {
        state = state.copy(isLoading = false)
    }

    private fun showLoading() {
        state = state.copy(isLoading = true)
    }
}