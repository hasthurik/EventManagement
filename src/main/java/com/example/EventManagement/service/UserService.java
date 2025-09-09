package com.example.EventManagement.service;

import com.example.EventManagement.DTO.UserDTO;
import com.example.EventManagement.DTO.UserMapper;
import com.example.EventManagement.emailValidator.EmailValidator;
import com.example.EventManagement.entity.UserEntity;
import com.example.EventManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;
    private final UserMapper mapper;
    private final EmailValidator emailValidator;

    public UserDTO getUserById(Long id) {
        return mapper.userToUserDTO(repo.findById(id).orElse(null));
    }

    public List<UserEntity> getAllUs() {
        return repo.findAll();
    }

    public UserDTO addUser(UserEntity user) {
        UserDTO userDto = new UserDTO();
        userDto = mapper.userToUserDTO(user);
        if (emailValidator.isValid(user.getEmail())) {
            repo.save(user);
            return userDto;
        }
        return null;
    }

    public void deleteUserById(Long id) {
        repo.deleteById(id);
    }
}
