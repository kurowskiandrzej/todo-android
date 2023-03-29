package com.kurowskiandrzej.auth_domain.use_case

import javax.inject.Inject

class ValidateEmailUseCase @Inject constructor() {
    private val emailPattern = """^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+${'$'}"""

    operator fun invoke(email: String): Boolean {
        return email.matches(Regex(emailPattern))
    }
}