package com.babtective.bap.dto;

import com.babtective.bap.domain.User;

// 사용자 응답용 DTO (비밀번호 등 민감정보 제외)
public class UserResponseDto {
    // 사용자 PK
    private Long id;
    // 이름
    private String name;
    // 이메일(로그인 ID)
    private String email;

    // 모든 필드를 채우는 생성자
    public UserResponseDto(Long id, String name, String email) {
        this.id = id; this.name = name; this.email = email;
    }

    // JSON 직렬화를 위한 getter
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    // *엔티티 -> DTO 변환
    public static UserResponseDto from(User u) {
        return new UserResponseDto(u.getId(), u.getName(), u.getEmail());
    }
}
