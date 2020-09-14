package com.example.dersnotu.service.user;

import com.example.dersnotu.dto.Register;
import com.example.dersnotu.dto.UserDTO;
import com.example.dersnotu.entity.Note;
import com.example.dersnotu.entity.User;
import com.example.dersnotu.exception.PasswordsDoNotMatch;
import com.example.dersnotu.repository.NoteRepository;
import com.example.dersnotu.repository.UserRepository;
import com.example.dersnotu.service.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public UserDTO getUserProfile() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDTO userDTO = userMapper.toDTO(user);

        List<Note> selfNotes = noteRepository.findAllByOwnerId(userDTO.getId(), PageRequest.of(0, 20));
        userDTO.setSelfNotes(selfNotes);

        String jsonArray = toJSONArray(user.getFavNotes());
        System.out.println(jsonArray);
        List<Note> favNotes = noteRepository.findFavNotesFromIds(jsonArray);
        userDTO.setFavouriteNotes(favNotes);

        System.out.println(userDTO);
        return userDTO;
    }

    @Override
    public void saveNote(String noteId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.getFavNotes().add(noteId);
        userRepository.save(user);
    }

    private String toJSONArray(List<String> noteNames) {
        StringBuilder json = new StringBuilder("[");
        String prefix = "";
        for (String note: noteNames) {
            json.append(prefix);
            prefix = ",";
            json.append("\"");
            json.append(note);
            json.append("\"");

        }
        json.append("]");

        return json.toString();
    }

    @Override
    public void updateProfile(UserDTO userDTO) throws PasswordsDoNotMatch {
        User oldUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (userDTO.getPassword1().length() > 0) {
            if (userDTO.getPassword1().equals(userDTO.getPassword2())) {
                oldUser.setPassword(userDTO.getPassword1());
            } else {
                throw new PasswordsDoNotMatch("");
            }
        }

        if (userDTO.getEmail().length() > 0) {
            oldUser.setEmail(userDTO.getEmail());
        }

        if (userDTO.getUniversity().length() > 0) {
            oldUser.setUniversity(userDTO.getUniversity());
        }

        if (userDTO.getDepartment().length() > 0) {
            oldUser.setDepartment(userDTO.getDepartment());
        }

        if (userDTO.getProfilePictureUrl().length() > 0) {
            oldUser.setProfilePictureUrl(userDTO.getProfilePictureUrl());
        }

        userRepository.save(oldUser);
    }
}
