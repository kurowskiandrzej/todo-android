package com.kurowskiandrzej.auth_presentation.register

import com.kurowskiandrzej.core_ui.util.UiText

data class RegisterUiState(
    val isLoading: Boolean = false,
    val shouldValidateOnInput: Boolean = false,
    val emailInput: String = "",
    val emailValidationErrorMessage: UiText? = null,
    val passwordInput: String = "",
    val passwordValidationErrorMessage: UiText? = null,
    val passwordConfirmationInput: String = "",
    val passwordConfirmationValidationErrorMessage: UiText? = null,
    val isPasswordVisible: Boolean = false
)