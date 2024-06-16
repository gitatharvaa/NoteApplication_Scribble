package com.example.scribble.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.scribble.model.Note
import kotlinx.coroutines.flow.Flow

@Dao //Data access object
interface ScribbleDatabaseDao { //this interacts with the database

@Query("SELECT * from scribble_tbl")
fun getNotes():
        Flow<List<Note>> //flow is very imp for Room DB

@Query("Select * from scribble_tbl where id =:id")
suspend fun getNoteById(id : String): Note

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insert(note: Note)

@Update(onConflict = OnConflictStrategy.REPLACE)
suspend fun update(note: Note)

@Query("Delete from scribble_tbl")
suspend fun deleteAll()

@Delete
suspend fun deleteNote(note: Note)
//we use suspend to work in corountine, so that these functions work asynchronously

}
