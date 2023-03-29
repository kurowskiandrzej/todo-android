package com.kurowskiandrzej.auth_domain.use_case

import com.kurowskiandrzej.auth_domain.repository.AuthRepository
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<Unit> {
        return authRepository.loginUser(
            email,
            password
        )
    }
}