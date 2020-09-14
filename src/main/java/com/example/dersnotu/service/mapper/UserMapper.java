package com.example.dersnotu.service.mapper;

import com.example.dersnotu.dto.Register;
import com.example.dersnotu.dto.UserDTO;
import com.example.dersnotu.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    User registerToUser(Register register);
    UserDTO toDTO(User user);
    @Mapping(target = "password", source = "password1")
    User toUser(UserDTO userDTO);
}
