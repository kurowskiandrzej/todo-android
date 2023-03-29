package com.kurowskiandrzej.auth_data.di

import com.kurowskiandrzej.auth_data.remote.api.AuthApi
import com.kurowskiandrzej.auth_data.repository.AuthRepositoryImpl
import com.kurowskiandrzej.auth_domain.repository.AuthRepository
import com.kurowskiandrzej.core.domain.preferences.AuthPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthDataModule {

    @Provides
    @Singleton
    fun provideAuthApi(
        client: OkHttpClient
    ): AuthApi {
        return Retrofit.Builder()
            .baseUrl(AuthApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        authApi: AuthApi,
        authPreferences: AuthPreferences
    ): AuthRepository =
        AuthRepositoryImpl(
            authApi,
            authPreferences
        )
}