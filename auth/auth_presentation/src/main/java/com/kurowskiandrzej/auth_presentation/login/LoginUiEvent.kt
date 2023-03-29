package com.kurowskiandrzej.auth_presentation.login

sealed interface LoginUiEvent {

    data class OnEmailInput(val emailInput: String) : LoginUiEvent

    data class OnPasswordInput(val passwordInput: String) : LoginUiEvent

    data class OnLoginClick(val onSuccess: () -> Unit) : LoginUiEvent

    object TogglePasswordVisibility : LoginUiEvent
}