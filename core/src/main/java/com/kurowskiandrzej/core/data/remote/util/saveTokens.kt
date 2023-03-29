package com.kurowskiandrzej.core.data.remote.util

import com.kurowskiandrzej.core.domain.preferences.AuthPreferences
import okhttp3.Headers

fun saveTokens(
    authPreferences: AuthPreferences,
    headers: Headers?,
    accessToken: String?
) {
    if (accessToken == null) return

    authPreferences.insertAccessToken(accessToken)

    headers?.let {
        it["set-cookie"]?.let { refreshToken ->
            authPreferences.insertRefreshToken(refreshToken)
        }
    }
}