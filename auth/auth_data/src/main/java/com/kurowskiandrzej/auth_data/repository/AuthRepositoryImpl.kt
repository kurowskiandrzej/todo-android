package com.kurowskiandrzej.auth_data.repository

import com.kurowskiandrzej.core.data.remote.api_call_handler.apiCall
import com.kurowskiandrzej.auth_data.remote.api.AuthApi
import com.kurowskiandrzej.auth_domain.repository.AuthRepository
import com.kurowskiandrzej.core.data.remote.util.saveTokens
import com.kurowskiandrzej.core.domain.preferences.AuthPreferences
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val authPreferences: AuthPreferences
) : AuthRepository {

    override suspend fun registerUser(email: String, password: String): Result<Unit> {
        return apiCall {
            val registerResponse = authApi.registerUser(email, password).apply {
                body()?.let { dto ->
                    saveTokens(authPreferences, headers(), dto.accessToken)
                }
            }

            if (registerResponse.code() >= 400) {
                throw Exception(registerResponse.message())
            }
        }
    }

    override suspend fun loginUser(email: String, password: String): Result<Unit> {
        return apiCall {
            val loginResponse = authApi.loginUser(email, password).apply {
                body()?.let { dto ->
                    saveTokens(authPreferences, headers(), dto.accessToken)
                }
            }

            if (loginResponse.code() >= 400) {
                throw Exception(loginResponse.message())
            }
        }
    }

    override suspend fun logoutUser(): Result<Unit> {
        return apiCall {
            val logoutResponse = authApi.logoutUser()

            if (logoutResponse.code() >= 400) {
                throw Exception(logoutResponse.message())
            }
        }
    }
}