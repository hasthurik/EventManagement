package com.example.EventManagement.service;

import com.example.EventManagement.DTO.UserDTO;
import com.example.EventManagement.DTO.UserMapper;
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

    public UserDTO getUserById(Long id) {
        return mapper.userToUserDTO(repo.findById(id).orElse(null));
    }

    public List<UserEntity> getAllUs() {
        return repo.findAll();
    }

    public void addUser(UserEntity user) {
        repo.save(user);
    }

    public void deleteUserById(Long id) {
        repo.deleteById(id);
    }
}
