package spring_labs.spring_boot_mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import spring_labs.spring_boot_mybatis.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper // 해당 인터페이스가 MyBatis mapper 임을 나타냄
public interface UserMapper {

    // case1. 어노테이션 기반 매퍼
    // - 간단한 쿼리의 경우 간결하게 표현 가능
    // - Java 코드 내에서 SQL 을 직접 볼 수 있어 즉각적인 이해 가능
    // - @Select, @Insert, @Update, @Delete 어노테이션 사용
    @Select("SELECT * FROM users")
    List<User> findAll(); // 모든 사용자 조회

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(Long id); // 특정 ID 의 사용자 조회

    @Insert("INSERT INTO users (username, email) VALUES (#{username}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id") // Insert 작업에 대한 추가 옵션 설정
    // - useGeneratedKeys = true; 데이터베이스에서 자동 생성되는 키 (auto-increment pk) 를 사용하겠다는 의미
    // - keyProperty = "id"; 생성된 키 값을 User 객체의 어떤 속성에 설정할지 지정
    // => insert 메서드 호출 후 전달된 User 객체의 id 필드는 데이터베이스에서 생성된 실제 ID 값으로 업데이트
    //      이를 통해 새로 삽입된 레코드의 ID 를 즉시 알 수 있으며, 이후 작업에 이 ID 사용 가능 (새 레코드 삽입한 직후 해당 레코드 ID 필요한 경우 유용)
    void insert(User user); // 새 사용자를 추가, Options 어노테이션으로 생성된 키를 User 객체에 설정

    @Update("UPDATE users SET username = #{username}, email = #{email} WHERE id = #{id}")
    void update(User user); // 사용자 정보를 업데이트

    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Long id); // 특정 ID 의 사용자를 삭제


    // case2. XML 기반 매퍼
    // - 복잡한 SQL 쿼리를 쉽게 관리 가능
    // - 동적 SQL 작성 편리
    // - SQL 과 Java 코드를 분리하여 관리 가능
    // - 대규모 프로젝트나 복잡한 데이터 조작에 적합
    //List<User> findAll();
    //User findById(Long id);
    //void insert(User user);
    //void update(User user);
    //void delete(Long id);

}