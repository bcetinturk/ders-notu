package com.example.dersnotu.service.mapper;

import com.example.dersnotu.dto.NewNote;
import com.example.dersnotu.entity.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface NoteMapper {
    @Mapping(target = "lectureNote", source = "newNote.note")
    Note newNote(NewNote newNote);
}
