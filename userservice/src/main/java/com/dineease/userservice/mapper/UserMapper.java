package com.dineease.userservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dineease.userservice.dto.UserDTO;
import com.dineease.userservice.entity.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOToUser(UserDTO userDTO);
    UserDTO mapUserToUserDTO(User user);
}
