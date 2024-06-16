package com.example.scribble.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.scribble.model.Note
import com.example.scribble.util.DateConverter
import com.example.scribble.util.UUIDConverter

@Database(entities = [Note :: class], version = 1, exportSchema = false )
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class ScribbleDatabase: RoomDatabase() {
    abstract fun noteDao(): ScribbleDatabaseDao // this knows how to create a DB

}