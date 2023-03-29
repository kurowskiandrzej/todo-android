package com.kurowskiandrzej.auth_data.remote.api

import com.kurowskiandrzej.core.ApiUrl
import com.kurowskiandrzej.auth_data.remote.dto.AccessTokenDto
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("api/register")
    suspend fun registerUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AccessTokenDto>

    @FormUrlEncoded
    @POST("api/login")
    suspend fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AccessTokenDto>

    @POST("logout")
    suspend fun logoutUser(): Response<Unit>

    companion object {
        const val BASE_URL = ApiUrl.AUTH_API_URL
    }
}