package com.example.dersnotu.service.note;

import com.example.dersnotu.dto.NewNote;
import com.example.dersnotu.entity.Note;
import com.example.dersnotu.entity.User;
import com.example.dersnotu.repository.NoteRepository;
import com.example.dersnotu.service.mapper.NoteMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultNoteService implements NoteService {
    private NoteMapper noteMapper = Mappers.getMapper(NoteMapper.class);
    NoteRepository noteRepository;

    @Autowired
    public DefaultNoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void addNewNote(NewNote newNote) {
        Note note = noteMapper.newNote(newNote);
        note.setOwnerId("Sample Id");
        note = noteRepository.save(note);
        System.out.println(note);
    }
}
