package com.babtective.bap.service;

import com.babtective.bap.domain.User;
import com.babtective.bap.dto.UserLoginRequestDto;
import com.babtective.bap.dto.UserResponseDto;
import com.babtective.bap.dto.UserSignupRequestDto;
import com.babtective.bap.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /** 회원가입 **/
    @Transactional
    public UserResponseDto signup(UserSignupRequestDto req) {
        // 이메일 중복 체크
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        // 엔티티 생성 + 비밀번호 해시 저장
        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setPasswordHash(encoder.encode(req.getPassword()));

        // 저장 후 DTO로 리턴(비밀번호는 응답에 포함 X)
        return UserResponseDto.from(userRepository.save(u));
    }

    /** 로그인 */
    @Transactional(readOnly = true)
    public UserResponseDto login(UserLoginRequestDto req) {
        User u = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 이메일입니다."));

        if (!encoder.matches(req.getPassword(), u.getPasswordHash())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return UserResponseDto.from(u);
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
