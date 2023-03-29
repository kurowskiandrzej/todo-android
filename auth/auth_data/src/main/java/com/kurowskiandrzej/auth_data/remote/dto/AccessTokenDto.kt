package com.kurowskiandrzej.auth_data.remote.dto

import com.squareup.moshi.Json

data class AccessTokenDto(
    @field:Json(name = "access_token")
    val accessToken: String
)
