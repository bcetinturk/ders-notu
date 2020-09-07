package com.example.dersnotu.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class Register {
    @Size(min = 1, message = "İsim boş bırakılamaz")
    private String fullName;

    @Size(min = 1, message = "E-posta boş olamaz")
    private String email;

    @Size(min = 8, message = "Şifre en az 8 karakter olmalı")
    private String password;

    private String university;
    private String department;
}
