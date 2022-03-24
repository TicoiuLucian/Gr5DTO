package com.example.dto.mapper;

import com.example.dto.entity.UserEntity;
import com.example.dto.rest.model.UserDTO;

public class UserMapper {

    //o metoda de transformat dto -> entity (vine din frontend si se duce in DB)
    public static UserEntity fromDTOToEntity(UserDTO userDTO) {
        return new UserEntity(userDTO.getUsername(), userDTO.getPassword());
    }

    //o metoda de transformat entity -> dto (vine din DB si se duce in frontend)
    public static UserDTO fromEntityToDTO(UserEntity userEntity) {
        return new UserDTO(userEntity.getId(), userEntity.getUsername());
    }
}
