package com.example.dersnotu.service.note;

import com.example.dersnotu.dto.NewNote;
import com.example.dersnotu.dto.NoteSearch;
import com.example.dersnotu.entity.Note;

import java.util.List;

public interface NoteService {
    void addNewNote(NewNote note);
    List<Note> searchNote(NoteSearch noteSearch);
    List<Note> getNotesByOwner(String ownerId);
}
