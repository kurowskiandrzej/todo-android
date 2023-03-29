package com.kurowskiandrzej.core.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.kurowskiandrzej.core.BuildConfig
import com.kurowskiandrzej.core.data.preferences.AuthPreferencesImpl
import com.kurowskiandrzej.core.data.remote.interceptor.HeaderInterceptor
import com.kurowskiandrzej.core.domain.preferences.AuthPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    private const val CONNECT_TIMEOUT = 30L
    private const val READ_TIMEOUT = 15L
    private const val WRITE_TIMEOUT = 15L
    private const val SHARED_PREFS = "shared_prefs"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(HeaderInterceptor())
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                val loggingBodyInterceptor = HttpLoggingInterceptor().apply {
                    this.level = HttpLoggingInterceptor.Level.BODY
                }
                val loggingHeaderInterceptor = HttpLoggingInterceptor().apply {
                    this.level = HttpLoggingInterceptor.Level.HEADERS
                }

                this.addInterceptor(loggingHeaderInterceptor)
                    .addInterceptor(loggingBodyInterceptor)
            }
        }.build()

        return client
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ): SharedPreferences {
        return app.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideAuthPreferences(
        sharedPreferences: SharedPreferences
    ): AuthPreferences {
        return AuthPreferencesImpl(sharedPreferences)
    }
}