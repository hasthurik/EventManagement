package com.example.EventManagement.DTO;

import com.example.EventManagement.DTO.request.UserRequest;
import com.example.EventManagement.DTO.response.UserResponse;
import com.example.EventManagement.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse userEntityToUserResponse(UserEntity userEntity);
    UserEntity userResponseToUserEntity(UserResponse userResponse);

    UserRequest userEntityToUserRequest(UserEntity userEntity);
    UserEntity userRequestToUserEntity(UserRequest userRequest);

}
