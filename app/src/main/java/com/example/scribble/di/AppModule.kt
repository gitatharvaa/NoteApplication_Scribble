package com.example.scribble.di

import android.content.Context
import androidx.room.Room
import com.example.scribble.data.ScribbleDatabase
import com.example.scribble.data.ScribbleDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
//hilt will run this below code
    @Singleton //singleton is use so that,we get only one instance of this particular item
    @Provides //provides something to the entire realm of this
    fun provideNotesDao(noteDatabase: ScribbleDatabase): ScribbleDatabaseDao
    = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): ScribbleDatabase
    = Room.databaseBuilder(
        context,
        ScribbleDatabase::class.java,
        "notes_db")
        .fallbackToDestructiveMigration()
        .build()
    //it knows everything and is imp for RoomDB to know how to create a database

}