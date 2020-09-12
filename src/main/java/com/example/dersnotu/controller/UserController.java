package com.example.dersnotu.controller;

import com.example.dersnotu.dto.NoteSearch;
import com.example.dersnotu.entity.User;
import com.example.dersnotu.service.note.NoteService;
import com.example.dersnotu.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    NoteService noteService;
    UserService userService;

    @Autowired
    public UserController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        userService.getUserProfile();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("noteSearch", new NoteSearch());
        model.addAttribute("student", user);
        model.addAttribute("studentNotes", noteService.getNotesByOwner(user.getId()));
        return "profile";
    }
}
