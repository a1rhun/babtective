package com.babtective.bap.controller;

import com.babtective.bap.domain.User;
import com.babtective.bap.dto.UserResponseDto;
import com.babtective.bap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors; // JDK 버전에 따라 필요

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody User user) {
        return UserResponseDto.from(userService.save(user));
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.findAll().stream()
                .map(UserResponseDto::from)
                .collect(Collectors.toList());//
    }
}
