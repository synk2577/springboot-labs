package com.group.libraryappsean.controller.user;

import com.group.libraryappsean.dto.user.request.UserCreateRequest;
import com.group.libraryappsean.dto.user.request.UserUpdateRequest;
import com.group.libraryappsean.dto.user.response.UserResponse;
import com.group.libraryappsean.service.user.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

//    private final List<User> users = new ArrayList<>();
    private final UserService userService;


    public UserController(JdbcTemplate jdbcTemplate) {
        // jdbcTemplate 을 각 계층 클래스의 메서드에 인자로 넘기기 번거로우므로 각 계층의 객체 생성시 생성자에서 자동으로 넘겨줌
        this.userService = new UserService(jdbcTemplate);
    }

    @PostMapping("/user") // POST /user - 유저 생성
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.createUser(request);
    }

    @GetMapping("/user") // GET /user - 유저 조회
    public List<UserResponse> getUsers() {
        return userService.readUser();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }

    // 예외 테스트
//   @GetMapping("/user/error-test")
//    public void errorTest() {
//        throw new IllegalArgumentException();
//   }
}
