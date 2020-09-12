package com.example.dersnotu.service.user;

import com.example.dersnotu.dto.Register;
import com.example.dersnotu.entity.Note;
import com.example.dersnotu.entity.User;
import com.example.dersnotu.repository.NoteRepository;
import com.example.dersnotu.repository.UserRepository;
import com.example.dersnotu.service.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository, NoteRepository noteRepository) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
    }

    @Override
    public void register(Register register) {
        User user = userMapper.registerToUser(register);
        userRepository.save(user);
    }

    @Override
    public void getUserProfile() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Note> favNotes = noteRepository.findFavNotesFromIds("[\"fIXhd3QB3KSnIME7O7aG\"]");
        System.out.println(favNotes);
    }
}
