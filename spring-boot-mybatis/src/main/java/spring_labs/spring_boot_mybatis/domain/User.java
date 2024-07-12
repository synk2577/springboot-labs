package spring_labs.spring_boot_mybatis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String email;
    private String createdAt;
}

// domain.User
// - 데이터베이스 엔티티를 표현하는 도메인 (데이터베이스 테이블과 직접적으로 매핑)


// < lombok 어노테이션 >
// @Data
// - @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode 어노테이션을 포함

// @Getter
// - 모든 필드에 대해 getter 메서드만 생성

// @Setter
// - 모든 필드에 대해 setter 메서드만 생성

// @Builder
// - 빌더 패턴을 구현하는 코드를 생성
// - 일반적으로 @AllArgsConstructor 와 함께 사용
