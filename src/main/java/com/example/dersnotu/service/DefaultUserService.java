package com.example.dersnotu.service;

import com.example.dersnotu.dto.Register;
import com.example.dersnotu.entity.User;
import com.example.dersnotu.repository.UserRepository;
import com.example.dersnotu.service.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserService {
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private UserRepository userRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(Register register) {
        User user = userMapper.registerToUser(register);
        userRepository.save(user);
    }
}
