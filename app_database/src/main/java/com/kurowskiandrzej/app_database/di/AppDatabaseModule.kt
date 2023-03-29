package com.kurowskiandrzej.app_database.di

import android.app.Application
import androidx.room.Room
import com.kurowskiandrzej.app_database.AppDatabase
import com.kurowskiandrzej.app_database.dao.ToDoListDao
import com.kurowskiandrzej.app_database.dao.ToDoTaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideToDoListDao(appDatabase: AppDatabase): ToDoListDao {
        return appDatabase.toDoListDao
    }

    @Provides
    @Singleton
    fun provideToDoTaskDao(appDatabase: AppDatabase): ToDoTaskDao {
        return appDatabase.toDoTaskDao
    }
}