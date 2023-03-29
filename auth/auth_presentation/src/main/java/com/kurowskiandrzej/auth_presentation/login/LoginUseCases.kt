package com.kurowskiandrzej.auth_presentation.login

import com.kurowskiandrzej.auth_domain.use_case.LoginUserUseCase
import com.kurowskiandrzej.auth_domain.use_case.ValidateEmailUseCase
import com.kurowskiandrzej.auth_domain.use_case.ValidatePasswordUseCase
import javax.inject.Inject

data class LoginUseCases @Inject constructor(
    val loginUser: LoginUserUseCase,
    val validateEmail: ValidateEmailUseCase,
    val validatePassword: ValidatePasswordUseCase
)