package com.example.EventManagement.service;

import com.example.EventManagement.entity.UserEntity;
import com.example.EventManagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public UserEntity getUserById(Long id) {
        return repo.findById(id).orElse(null);
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
