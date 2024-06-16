package com.example.scribble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.scribble.screens.NoteViewModel
import com.example.scribble.screens.ScribbleScreen
import com.example.scribble.ui.theme.ScribbleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScribbleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val noteViewModel = viewModel<NoteViewModel>()
                    ScribbleApp(noteViewModel)

                }
            }
        }
    }
}

@Composable
fun ScribbleApp(noteViewModel: NoteViewModel ){
    val notesList = noteViewModel.noteList.collectAsState().value //flow of data

    ScribbleScreen(notes = notesList,
        onRemoveNote = { noteViewModel.removeNote(it) },
        onAddNote = { noteViewModel.addNote(it) })
}


@Preview(showBackground = true)
@Composable
//fun GreetingPreview() {
fun DefaultPreview(){
    ScribbleTheme {

    }
}