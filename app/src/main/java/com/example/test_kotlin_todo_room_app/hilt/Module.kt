package com.example.test_kotlin_todo_room_app.hilt

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.example.test_kotlin_todo_room_app.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        databaseBuilder(context, AppDatabase::class.java, "task_database").build()

    @Provides
    fun provideDao(db: AppDatabase) = db.taskDao()
}
