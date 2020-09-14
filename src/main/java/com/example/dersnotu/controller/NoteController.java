package com.example.dersnotu.controller;

import com.example.dersnotu.dto.NewNote;
import com.example.dersnotu.dto.NoteSearch;
import com.example.dersnotu.entity.Note;
import com.example.dersnotu.service.note.NoteService;
import com.example.dersnotu.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NoteController {
    NoteService noteService;
    private UserService userService;

    @Autowired
    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping("/newnote")
    public String addNewNote(Model model){
        model.addAttribute("newNote", new NewNote());
        model.addAttribute("noteSearch", new NoteSearch());
        return "newnote";
    }

    @PostMapping("/newnote")
    public String handleNewNote(@ModelAttribute("newNote") NewNote newNote) {
        noteService.addNewNote(newNote);
        return "redirect:/profile";
    }

    @GetMapping("/search")
    public String handleSearchNote(@ModelAttribute("noteSearch") NoteSearch noteSearch, Model model) {
        List<Note> notes = noteService.searchNote(noteSearch);
        model.addAttribute("notes", notes);

        return "search";
    }

    @GetMapping("/note/{id}")
    public String getNote(@PathVariable String id, Model model) {
        Note note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        model.addAttribute("noteSearch", new NoteSearch());
        return "note";
    }

    @GetMapping("/save/{id}")
    public String saveFavouriteNote(@PathVariable("id") String noteId) {
        userService.saveNote(noteId);
        return "redirect:/profile";
    }
}
