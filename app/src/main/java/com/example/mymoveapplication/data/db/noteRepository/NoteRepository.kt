package com.example.mymoveapplication.data.db.noteRepository

import com.example.mymoveapplication.data.db.noteEntity.NoteModule

interface NoteRepository {

    val allNote: List<NoteModule>
    suspend fun insertNote(noteModule: NoteModule)
}