package com.kurowskiandrzej.core.data.preferences

import android.content.SharedPreferences
import com.kurowskiandrzej.core.domain.preferences.AuthPreferences

class AuthPreferencesImpl(
    private val sharedPreferences: SharedPreferences
) : AuthPreferences {

    override fun insertRefreshToken(refreshToken: String) {
        sharedPreferences
            .edit()
            .putString(AuthPreferences.REFRESH_TOKEN, refreshToken)
            .apply()
    }

    override fun insertAccessToken(accessToken: String) {
        sharedPreferences
            .edit()
            .putString(AuthPreferences.ACCESS_TOKEN, "token=$accessToken")
            .apply()

    }

    override fun getRefreshToken(): String? {
        return sharedPreferences
            .getString(AuthPreferences.REFRESH_TOKEN, null)
    }

    override fun getAccessToken(): String? {
        return sharedPreferences
            .getString(AuthPreferences.ACCESS_TOKEN, null)
    }

    override fun deleteAccessAndRefreshTokens() {
        sharedPreferences
            .edit()
            .apply {
                remove(AuthPreferences.ACCESS_TOKEN)
                    .apply()

                remove(AuthPreferences.REFRESH_TOKEN)
                    .apply()
            }
    }
}