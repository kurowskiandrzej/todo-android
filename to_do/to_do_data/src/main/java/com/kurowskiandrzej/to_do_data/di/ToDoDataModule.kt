package com.kurowskiandrzej.to_do_data.di

import com.kurowskiandrzej.app_database.dao.ToDoListDao
import com.kurowskiandrzej.app_database.dao.ToDoTaskDao
import com.kurowskiandrzej.core.domain.preferences.AuthPreferences
import com.kurowskiandrzej.to_do_data.remote.ToDoListApi
import com.kurowskiandrzej.to_do_data.remote.ToDoTaskApi
import com.kurowskiandrzej.to_do_data.repository.ToDoListRepositoryImpl
import com.kurowskiandrzej.to_do_data.repository.ToDoTaskRepositoryImpl
import com.kurowskiandrzej.to_do_domain.repository.ToDoListRepository
import com.kurowskiandrzej.to_do_domain.repository.ToDoTaskRepository
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
object ToDoDataModule {

    @Provides
    @Singleton
    fun provideToDoListApi(
        client: OkHttpClient
    ): ToDoListApi {
        return Retrofit.Builder()
            .baseUrl(ToDoListApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideToDoTaskApi(
        client: OkHttpClient
    ): ToDoTaskApi {
        return Retrofit.Builder()
            .baseUrl(ToDoTaskApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideToDoListRepository(
        toDoListApi: ToDoListApi,
        toDoTaskApi: ToDoTaskApi,
        toDoListDao: ToDoListDao,
        toDoTaskDao: ToDoTaskDao,
        authPreferences: AuthPreferences
    ): ToDoListRepository {
        return ToDoListRepositoryImpl(
            toDoListApi = toDoListApi,
            toDoTaskApi = toDoTaskApi,
            toDoListDao = toDoListDao,
            toDoTaskDao = toDoTaskDao,
            authPreferences = authPreferences
        )
    }

    @Provides
    @Singleton
    fun providesToDoTaskRepository(
        toDoTaskApi: ToDoTaskApi,
        toDoTaskDao: ToDoTaskDao
    ): ToDoTaskRepository {
        return ToDoTaskRepositoryImpl(
            toDoTaskApi = toDoTaskApi,
            toDoTaskDao = toDoTaskDao
        )
    }
}