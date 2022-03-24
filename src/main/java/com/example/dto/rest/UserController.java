package com.example.dto.rest;

import com.example.dto.entity.UserEntity;
import com.example.dto.mapper.UserMapper;
import com.example.dto.repository.UserRepository;
import com.example.dto.rest.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        //programare procedurala
        List<UserDTO> userDTOS = new ArrayList<>();
        for (UserEntity userEntity : userRepository.findAll()) {
            userDTOS.add(UserMapper.fromEntityToDTO(userEntity));
        }
        return userDTOS;

        //programare functionala
//        return userRepository.findAll().stream().map(UserMapper::fromEntityToDTO).collect(Collectors.toList());
    }

    @PostMapping("/insert")
    public UserDTO insertUser(@RequestBody UserDTO userDTO) {
        return UserMapper.fromEntityToDTO(userRepository.save(UserMapper.fromDTOToEntity(userDTO)));
    }
}
