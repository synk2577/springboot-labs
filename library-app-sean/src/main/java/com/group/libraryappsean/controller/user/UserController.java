package com.group.libraryappsean.controller.user;

import com.group.libraryappsean.domain.user.User;
import com.group.libraryappsean.dto.user.request.UserCreateRequest;
import com.group.libraryappsean.dto.user.request.UserUpdateRequest;
import com.group.libraryappsean.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

//    private final List<User> users = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate; // JdbcTemplate: jdbc에 대한 커넥터

    public UserController(JdbcTemplate jdbcTemplate) {
        // jdbcTemplate 를 생성자에 직접 넣지 않더라도 Spring이 알아서 jdbcTemplate을 넣어줌
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/user") // POST /user - 유저 생성
    public void saveUser(@RequestBody UserCreateRequest request) {
//        users.add(new User(request.getName(), request.getAge()));
        String sql = "insert into user (name, age) values (?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getAge());
    }

    @GetMapping("/user") // GET /user - 유저 조회
    public List<UserResponse> getUsers() {
//        List<UserResponse> responses = new ArrayList<>();
//        for (int i = 0; i < users.size(); i++) {
//            responses.add(new UserResponse(i + 1, users.get(i)));
//        }
//
//        return responses;

        String sql = "select * from user";
//        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
//            @Override
//            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
//                long id = rs.getLong("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                return new UserResponse(id, name, age);
//            }
//        });

        // 위 코드를 java lambda를 사용해 간결하게!
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, request.getName(), request.getId());
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        String sql = "DELETE FROM user where name = ?";
        jdbcTemplate.update(sql, name);
    }
}
