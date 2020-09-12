package com.example.dersnotu.service.mapper;

import com.example.dersnotu.dto.Register;
import com.example.dersnotu.dto.UserDTO;
import com.example.dersnotu.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User registerToUser(Register register);
    UserDTO toDTO(User user);
}
