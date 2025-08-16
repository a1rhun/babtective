package com.babtective.bap.controller;

import com.babtective.bap.dto.UserLoginRequestDto;
import com.babtective.bap.dto.UserResponseDto;
import com.babtective.bap.dto.UserSignupRequestDto;
import com.babtective.bap.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
//로그인 회원가입 controller
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;
    //회원가입
    @PostMapping(value="/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto signup(@RequestBody UserSignupRequestDto req) {
        log.info("signup req = name={}, email={}", req.getName(), req.getEmail());
        return userService.signup(req);
    }
    //로그인
    @PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto login(@RequestBody UserLoginRequestDto req) {
        log.info("login req = email={}", req.getEmail());
        return userService.login(req);
    }
}
