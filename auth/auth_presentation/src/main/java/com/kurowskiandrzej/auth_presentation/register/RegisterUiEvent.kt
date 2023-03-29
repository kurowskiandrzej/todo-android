package com.kurowskiandrzej.auth_presentation.register

sealed interface RegisterUiEvent {

    data class OnEmailInput(val emailInput: String) : RegisterUiEvent

    data class OnPasswordInput(val passwordInput: String) : RegisterUiEvent

    data class OnPasswordConfirmationInput(val passwordConfirmationInput: String) : RegisterUiEvent

    data class OnRegisterClick(val onSuccess: () -> Unit) : RegisterUiEvent

    object TogglePasswordVisibility : RegisterUiEvent
}