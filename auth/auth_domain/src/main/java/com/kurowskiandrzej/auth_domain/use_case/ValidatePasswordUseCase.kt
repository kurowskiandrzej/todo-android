package com.kurowskiandrzej.auth_domain.use_case

import com.kurowskiandrzej.auth_domain.AuthConstants
import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor() {

    operator fun invoke(password: String): ValidatePasswordResult {
        val whiteSpaceRegex = Regex(pattern = """\s""")
        val specialCharacterRegex = Regex(pattern = """[#?!@${'$'}%^&*-]""")
        val digitRegex = Regex(pattern = """\d""")

        val result = ValidatePasswordResult.Failure(
            isTooShort = password.length < AuthConstants.MINIMUM_PASSWORD_LENGTH,
            isTooLong = password.length > AuthConstants.MAX_PASSWORD_LENGTH,
            noLowerCaseLetter = password == password.uppercase(),
            noUpperCaseLetter = password == password.lowercase(),
            noDigit = !password.contains(digitRegex),
            noSpecialCharacter = !password.contains(specialCharacterRegex),
            containsWhiteSpaces = password.contains(whiteSpaceRegex)
        )

        return if (
            result.isTooShort
            || result.isTooLong
            || result.noLowerCaseLetter
            || result.noUpperCaseLetter
            || result.noDigit
            || result.noSpecialCharacter
            || result.containsWhiteSpaces
        ) {
            result
        } else {
            ValidatePasswordResult.Success
        }
    }
}