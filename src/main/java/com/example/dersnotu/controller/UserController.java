package com.example.dersnotu.controller;

import com.example.dersnotu.dto.NoteSearch;
import com.example.dersnotu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/profile")
    public String getProfile(Model model) {
        model.addAttribute("noteSearch", new NoteSearch());
        model.addAttribute("student", new User("123", "Baris", "baris@baris.com", "qwertyuıop", "", "", "https://i.ibb.co/Yp8dK7B/default-profile.png"));
        return "profile";
    }
}
