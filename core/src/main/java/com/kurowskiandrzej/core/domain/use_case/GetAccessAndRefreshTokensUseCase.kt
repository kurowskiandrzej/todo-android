package com.kurowskiandrzej.core.domain.use_case

import com.kurowskiandrzej.core.domain.preferences.AuthPreferences
import javax.inject.Inject

class GetAccessAndRefreshTokensUseCase @Inject constructor(
    private val authPreferences: AuthPreferences
) {
    operator fun invoke(): Pair<String?, String?> {
        val accessToken = authPreferences.getAccessToken()
        val refreshToken = authPreferences.getRefreshToken()

        return Pair(accessToken, refreshToken)
    }
}