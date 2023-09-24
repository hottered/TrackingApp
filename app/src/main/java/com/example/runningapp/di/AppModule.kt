package com.example.runningapp.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.example.runningapp.db.RunningDatabase
import com.example.runningapp.other.Constance.KEY_FIRST_TIME_TOGGLE
import com.example.runningapp.other.Constance.KEY_NAME
import com.example.runningapp.other.Constance.KEY_WEIGHT
import com.example.runningapp.other.Constance.RUNNING_DATABASE_NAME
import com.example.runningapp.other.Constance.SHARED_PREFERENCES_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Singleton
    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app:Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    )
        .allowMainThreadQueries()
        .build()
    
    @Singleton
    @Provides
    fun provideRunDao(db:RunningDatabase) = db.getRunDao()
    
    @Singleton
    @Provides
    fun provideSharedPreferences(
        @ApplicationContext app:Context
    ) = app.getSharedPreferences(SHARED_PREFERENCES_NAME,MODE_PRIVATE)
    
    @Singleton
    @Provides
    fun provideName(
        sharePref : SharedPreferences
    ) = sharePref.getString(KEY_NAME,"") ?: ""
    @Singleton
    @Provides
    fun provideWeight(
        sharePref : SharedPreferences
    ) = sharePref.getFloat(KEY_WEIGHT,80f)

    @Singleton
    @Provides
    fun provideFirstTimeToggle(
        sharePref : SharedPreferences
    ) = sharePref.getBoolean(KEY_FIRST_TIME_TOGGLE,true) 
}