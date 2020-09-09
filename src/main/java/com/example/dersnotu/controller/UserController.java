package com.example.dersnotu.controller;

import com.example.dersnotu.dto.NoteSearch;
import com.example.dersnotu.entity.User;
import com.example.dersnotu.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    NoteService noteService;

    @Autowired
    public UserController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        model.addAttribute("noteSearch", new NoteSearch());
        User user = new User("Sample Id", "Baris", "baris@baris.com", "qwertyuıop", "", "", "https://i.ibb.co/Yp8dK7B/default-profile.png");
        model.addAttribute("student", user);
        model.addAttribute("studentNotes", noteService.getNotesByOwner(user.getId()));
        return "profile";
    }
}
