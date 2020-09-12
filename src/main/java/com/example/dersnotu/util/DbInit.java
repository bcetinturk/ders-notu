package com.example.dersnotu.util;

import com.example.dersnotu.entity.User;
import com.example.dersnotu.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class DbInit {
    UserRepository userRepository;

    public DbInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    void initDb() {
        if(userRepository.count() < 0) {
            User user = new User("", "Barış Çetintürk", "baris@gmail.com", "123123123", "", "", "", new ArrayList<>());
            userRepository.save(user);
        }
    }
}
