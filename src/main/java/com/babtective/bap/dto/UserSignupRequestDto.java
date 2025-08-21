package com.babtective.bap.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// *회원가입 요청 DTO (클라이언트 → 서버)
// 비밀번호는 평문으로 들어오며, 서비스에서 BCrypt로 해시해 저장
@Getter @Setter
@NoArgsConstructor
public class UserSignupRequestDto {
    // 이름
    private String name;
    // 로그인 이메일
    private String email;
    // 비밀번호(평문)
    private String password;
}
