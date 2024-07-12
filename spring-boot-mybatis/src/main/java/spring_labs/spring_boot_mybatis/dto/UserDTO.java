package spring_labs.spring_boot_mybatis.dto;

import lombok.*;

@Getter // getter 메서드
@Setter // setter 메서드
@NoArgsConstructor // 매개변수 없는 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자
@Builder // 빌더 패턴 사용 가능하도록 유연성 제공
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    // domain.User 와 다르게 "no" 항목 추가
    // 실제 테이블에 존재하는 컬럼은 아니지만, 서비스 로직에서 no 정보를 활용할 예정
    private int no;
}

// dto.UserDTO
// - 데이터 전송 객체(dto)로 클라이언트와 서버 간의 데이터 교환에 사용
// - 클라이언트에게 노출하고 싶지 않은 민감한 정보를 User 객체에 포함 시키고, DTO 변환 과정에서 제외할 수 있음

