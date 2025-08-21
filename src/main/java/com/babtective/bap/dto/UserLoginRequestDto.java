package com.babtective.bap.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserLoginRequestDto { //로그인 Dto*
    private String email;
    private String password;
}
