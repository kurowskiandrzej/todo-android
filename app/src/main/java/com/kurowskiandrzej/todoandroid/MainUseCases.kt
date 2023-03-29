package com.kurowskiandrzej.todoandroid

import com.kurowskiandrzej.core.domain.use_case.GetAccessAndRefreshTokensUseCase
import com.kurowskiandrzej.to_do_domain.use_case.FetchDataUseCase
import javax.inject.Inject

data class MainUseCases @Inject constructor(
    val getAccessAndRefreshTokens: GetAccessAndRefreshTokensUseCase,
    val fetchData: FetchDataUseCase
)