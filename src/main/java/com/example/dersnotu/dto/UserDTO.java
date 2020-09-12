package com.example.dersnotu.dto;

import com.example.dersnotu.entity.Note;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String id;
    private String fullName;
    private String university;
    private String department;
    private String profilePictureUrl;
    private List<Note> selfNotes;
    private List<Note> favouriteNotes;
}
