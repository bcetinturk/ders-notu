package com.example.dersnotu.service.user;

import com.example.dersnotu.dto.Register;

public interface UserService {
    void register(Register register);
    void getUserProfile();
}
