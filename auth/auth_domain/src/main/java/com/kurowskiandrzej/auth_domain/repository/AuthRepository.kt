package com.kurowskiandrzej.auth_domain.repository

interface AuthRepository {

    suspend fun registerUser(email: String, password: String): Result<Unit>

    suspend fun loginUser(email: String, password: String): Result<Unit>

    suspend fun logoutUser(): Result<Unit>
}