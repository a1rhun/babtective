package com.babtective.bap.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// 회원가입 요청을 위한 DTO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {
    private String email;
    private String username;
    private String password;
}
