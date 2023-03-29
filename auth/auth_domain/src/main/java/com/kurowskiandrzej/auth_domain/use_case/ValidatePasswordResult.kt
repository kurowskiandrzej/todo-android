package com.kurowskiandrzej.auth_domain.use_case

sealed interface ValidatePasswordResult {

    object Success : ValidatePasswordResult

    data class Failure(
        val isTooShort: Boolean = false,
        val isTooLong: Boolean = false,
        val noLowerCaseLetter: Boolean = false,
        val noUpperCaseLetter: Boolean = false,
        val noDigit: Boolean = false,
        val noSpecialCharacter: Boolean = false,
        val containsWhiteSpaces: Boolean = false
    ) : ValidatePasswordResult
}