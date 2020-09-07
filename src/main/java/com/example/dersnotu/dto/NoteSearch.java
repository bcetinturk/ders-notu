package com.example.dersnotu.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class NoteSearch {
    @NotEmpty
    private String lectureName;
}
