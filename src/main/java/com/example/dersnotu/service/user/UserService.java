package com.example.dersnotu.service.user;

import com.example.dersnotu.dto.Register;
import com.example.dersnotu.dto.UserDTO;
import com.example.dersnotu.exception.PasswordsDoNotMatch;

public interface UserService {
    void register(Register register);
    UserDTO getUserProfile();
    void saveNote(String noteId);
    void updateProfile(UserDTO userDTO) throws PasswordsDoNotMatch;
}
