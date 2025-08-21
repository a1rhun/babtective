package com.babtective.bap.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// 로그인 요청을 위한 DTO
// Spring Security의 기본 로그인 필터는 이 DTO를 직접 사용하지 않습니다.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    private String email;
    private String password;
}
