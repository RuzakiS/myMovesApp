package com.example.mymoveapplication.data.db.noteRepository

import com.example.mymoveapplication.data.db.dao.NoteDao
import com.example.mymoveapplication.data.db.noteEntity.NoteModule

class NoteRealisation(
    private val noteDao: NoteDao
): NoteRepository {
    override val allNote: List<NoteModule>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModule: NoteModule) {
        noteDao.insert(noteModule)

    }
}