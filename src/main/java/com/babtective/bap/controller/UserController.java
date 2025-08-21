package com.babtective.bap.controller;

import com.babtective.bap.dto.LoginRequestDto;
import com.babtective.bap.dto.LoginResponseDto;
import com.babtective.bap.dto.SignUpRequestDto;
import com.babtective.bap.service.UserService;
import com.babtective.bap.dto.CommonResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpRequestDto dto) {
        try {
            userService.signUp(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public CommonResponseDto<LoginResponseDto> login(@RequestBody LoginRequestDto dto) {
        try {
            LoginResponseDto loginResponse = userService.login(dto);
            return CommonResponseDto.success(HttpStatus.OK.value(), "로그인 성공", loginResponse);
        } catch (AuthenticationException e) {
            return (CommonResponseDto<LoginResponseDto>) CommonResponseDto.fail(HttpStatus.UNAUTHORIZED.value(), "이메일 또는 비밀번호가 올바르지 않습니다.");
        }
    }
}
