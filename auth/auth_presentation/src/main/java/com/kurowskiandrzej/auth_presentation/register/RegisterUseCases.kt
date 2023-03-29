package com.kurowskiandrzej.auth_presentation.register

import com.kurowskiandrzej.auth_domain.use_case.RegisterUserUseCase
import com.kurowskiandrzej.auth_domain.use_case.ValidateEmailUseCase
import com.kurowskiandrzej.auth_domain.use_case.ValidatePasswordUseCase
import javax.inject.Inject

data class RegisterUseCases @Inject constructor(
    val registerUser: RegisterUserUseCase,
    val validateEmail: ValidateEmailUseCase,
    val validatePassword: ValidatePasswordUseCase
)