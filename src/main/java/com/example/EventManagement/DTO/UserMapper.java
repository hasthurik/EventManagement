package com.example.EventManagement.DTO;

import com.example.EventManagement.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(UserEntity userEntity);
    UserEntity userDTOToUserEntity(UserDTO userDTO);
}
