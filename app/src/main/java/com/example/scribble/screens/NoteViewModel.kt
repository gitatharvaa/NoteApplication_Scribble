package com.example.scribble.screens


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scribble.model.Note
import com.example.scribble.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {
   // private var noteList = mutableStateListOf<Note>()

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow() //this should have all of the data from our database

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNote().distinctUntilChanged()
                .collect { listOfNotes -> //.collectLatest
                    if (listOfNotes.isEmpty()){
                        Log.d("Empty", ":Empty list")
                    }else{
                        _noteList.value = listOfNotes
                    }

                }

        }
    // initially call the default notes
       // noteList.addAll(NoteDataSource().loadNotes())
    }



     fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }
     fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }
     fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }

}