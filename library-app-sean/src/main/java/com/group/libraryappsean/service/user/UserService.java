package com.group.libraryappsean.service.user;

import com.group.libraryappsean.dto.user.request.UserCreateRequest;
import com.group.libraryappsean.dto.user.request.UserUpdateRequest;
import com.group.libraryappsean.dto.user.response.UserResponse;
import com.group.libraryappsean.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

// Service 계층
// 현재 유저가 있는지 없는지 확인하고 예외처리
public class UserService {

    private final UserRepository userRepository;

    public UserService(JdbcTemplate jdbcTemplate) {
        userRepository = new UserRepository(jdbcTemplate);
    }

    // Service 단계에서는 Controller 가 변환한 request 객체를 바로 받기에 어노테이션 필요 없음
    public void createUser(UserCreateRequest request) {
        userRepository.saveUser(request.getName(), request.getAge());
    }

    public List<UserResponse> readUser() {
      return userRepository.readUser();
    }

    public void updateUser(UserUpdateRequest request) {
        if (userRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }

        userRepository.updateUserName(request.getName(), request.getId());
    }

    public void deleteUser(String name) {
        if (userRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }

        userRepository.deleteUserName(name);
    }
}
