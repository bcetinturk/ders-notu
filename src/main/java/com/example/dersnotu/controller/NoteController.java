package com.example.dersnotu.controller;

import com.example.dersnotu.dto.NewNote;
import com.example.dersnotu.dto.NoteSearch;
import com.example.dersnotu.entity.Note;
import com.example.dersnotu.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NoteController {
    NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/newnote")
    public String addNewNote(Model model){
        model.addAttribute("newNote", new NewNote());
        return "newnote";
    }

    @PostMapping("/newnote")
    public String handleNewNote(@ModelAttribute("newNote") NewNote newNote) {
        noteService.addNewNote(newNote);
        return null;
    }

    @GetMapping("/search")
    public String handleSearchNote(@ModelAttribute("noteSearch") NoteSearch noteSearch, Model model) {
        List<Note> notes = noteService.searchNote(noteSearch);
        model.addAttribute("notes", notes);

        return "search";
    }
}
