package com.example.scribble.repository

import com.example.scribble.data.ScribbleDatabaseDao
import com.example.scribble.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val scribbleDatabaseDao: ScribbleDatabaseDao) {

    suspend fun addNote(note: Note) = scribbleDatabaseDao.insert(note)
    suspend fun updateNote(note: Note) = scribbleDatabaseDao.update(note)
    suspend fun deleteNote(note: Note) = scribbleDatabaseDao.deleteNote(note)
    suspend fun deleteAllNotes(note: Note) = scribbleDatabaseDao.deleteAll()
    fun getAllNote(): Flow<List<Note>> = scribbleDatabaseDao.getNotes().flowOn(Dispatchers.IO)
        .conflate()
}