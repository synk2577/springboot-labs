package com.group.libraryappsean.controller.user;

import com.group.libraryappsean.domain.user.User;
import com.group.libraryappsean.dto.user.request.UserCreateRequest;
import com.group.libraryappsean.dto.user.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();

    @PostMapping("/user") // POST /user - 유저 생성
    public void saveUser(@RequestBody UserCreateRequest request) {
        users.add(new User(request.getName(), request.getAge()));
    }

    @GetMapping("/user") // GET /user - 유저 조회
    public List<UserResponse> getUsers() {
        List<UserResponse> responses = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            responses.add(new UserResponse(i + 1, users.get(i)));
        }

        return responses;
    }
}
