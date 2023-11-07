package com.group.libraryappsean.repository.user;

import com.group.libraryappsean.dto.user.request.UserUpdateRequest;
import com.group.libraryappsean.dto.user.response.UserResponse;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

// Repository 계층
// SQL을 이용해 실제 DB 와의 통신 담당
public class UserRepository {

  private final JdbcTemplate jdbcTemplate;

  public UserRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  // 유저 존재 여부 by id
  public boolean isUserNotExist(long id) {
    String readSql = "SELECT * FROM user WHERE id = ?"; // id 로 유저 존재 여부 확인
    // readSql 실행해 DB에 데이터 존재 여부 확인
    // .query(): 0은 최종적으로 List 로 반환 (GetMapping /user 참고)
    // (rs, rowNum) -> 0 : 조회 결과가 있다면 0 반환
    // request.getId() : readSql 의 ? 값에 id 대응
    return  jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
  }

  // 유저 존재 여부 by name
  public boolean isUserNotExist(String name) {
    String readSql = "SELECT * FROM user WHERE name = ?";
    return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
  }

  // insert sql
  public void saveUser(String name, Integer age) {
    String sql = "insert into user (name, age) values (?, ?)";
    jdbcTemplate.update(sql, name, age);
  }

  // select sql
  public List<UserResponse> readUser() {
    String sql = "select * from user";
    return jdbcTemplate.query(sql, (rs, rowNum) -> {
      long id = rs.getLong("id");
      String name = rs.getString("name");
      int age = rs.getInt("age");
      return new UserResponse(id, name, age);
    });
  }

  // update sql
  public void updateUserName( String name, long id) {
    String sql = "UPDATE user SET name = ? WHERE id = ?";
    jdbcTemplate.update(sql, name, id);
  }

  // delete sql
  public void deleteUserName(String name) {
    String sql = "DELETE FROM user where name = ?";
    jdbcTemplate.update(sql, name);
  }
}
