package com.kurowskiandrzej.core.domain.preferences

interface AuthPreferences {

    fun insertRefreshToken(refreshToken: String)

    fun insertAccessToken(accessToken: String)

    fun getRefreshToken(): String?

    fun getAccessToken(): String?

    fun deleteAccessAndRefreshTokens()

    companion object {
        const val REFRESH_TOKEN = "refresh_token"
        const val ACCESS_TOKEN = "access_token"
    }
}