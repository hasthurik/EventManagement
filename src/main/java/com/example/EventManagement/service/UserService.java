package com.example.EventManagement.service;

import com.example.EventManagement.DTO.UserMapper;
import com.example.EventManagement.DTO.request.UserRequest;
import com.example.EventManagement.DTO.response.UserResponse;
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

    public UserResponse getUserById(Long id) {
        return mapper.userEntityToUserResponse(repo.findById(id).orElse(null));
    }

    public List<UserEntity> getAllUs() {
        return repo.findAll();
    }

    //создание пользователя
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity = mapper.userRequestToUserEntity(userRequest);
        if (emailValidator.isValid(userRequest.getEmail())) {
            repo.save(userEntity);
            return mapper.userEntityToUserResponse(userEntity);
        } else {return null;}
    }

    public void deleteUserById(Long id) {
        repo.deleteById(id);
    }
}
