package com.kurowskiandrzej.auth_presentation.login

import com.kurowskiandrzej.core_ui.util.UiText

data class LoginUiState(
    val isLoading: Boolean = false,
    val shouldValidateOnInput: Boolean = false,
    val emailInput: String = "",
    val emailValidationErrorMessage: UiText? = null,
    val passwordInput: String = "",
    val passwordValidationErrorMessage: UiText? = null,
    val isPasswordVisible: Boolean = false
)
