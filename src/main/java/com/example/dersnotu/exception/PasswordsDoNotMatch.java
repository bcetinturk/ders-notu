package com.example.dersnotu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Passwords do not match.")
public class PasswordsDoNotMatch extends Exception {
    public PasswordsDoNotMatch(String message) {
        super(message);
    }
}
