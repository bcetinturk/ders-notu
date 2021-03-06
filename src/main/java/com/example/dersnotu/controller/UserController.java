package com.example.dersnotu.controller;

import com.example.dersnotu.dto.NoteSearch;
import com.example.dersnotu.dto.UserDTO;
import com.example.dersnotu.exception.PasswordsDoNotMatch;
import com.example.dersnotu.service.note.NoteService;
import com.example.dersnotu.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        UserDTO userDTO = userService.getUserProfile();
        model.addAttribute("noteSearch", new NoteSearch());
        model.addAttribute("student", userDTO);
        return "profile";
    }

    @GetMapping("/changeProfile")
    public String getChangeProfile(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        model.addAttribute("noteSearch", new NoteSearch());
        return "updateprofile";
    }

    @PostMapping("/changeProfile")
    public String handleChangeProfile(@ModelAttribute("userDTO") UserDTO userDTO, Model model) {
        try {
            userService.updateProfile(userDTO);
            return "redirect:/profile";
        } catch (PasswordsDoNotMatch passwordsDoNotMatch) {
            model.addAttribute("errorMessage", "Şifreler uyuşmuyor");
            return "updateprofile";
        }
    }
}
