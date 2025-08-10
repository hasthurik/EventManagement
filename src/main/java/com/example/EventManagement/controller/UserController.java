package com.example.EventManagement.controller;


import com.example.EventManagement.DTO.UserDTO;
import com.example.EventManagement.entity.UserEntity;
import com.example.EventManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> GetUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }


    //получение списка всех пользователей
    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>>  getAllUsers() {
         return new ResponseEntity<>(userService.getAllUs(), HttpStatus.OK);

    }
    //Создание нового пользователя
    @PostMapping("/create")
    public ResponseEntity<UserEntity> CreateUser(@RequestBody UserEntity user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserEntity> DeleteUser(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
