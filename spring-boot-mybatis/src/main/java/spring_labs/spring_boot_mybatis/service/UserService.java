package spring_labs.spring_boot_mybatis.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_labs.spring_boot_mybatis.domain.User;
import spring_labs.spring_boot_mybatis.dto.UserDTO;
import spring_labs.spring_boot_mybatis.mapper.UserMapper;

@Service // 이 클래스가 서비스 계층의 컴포넌트임을 나타냄
public class UserService {
    // UserMapper 인터페이스의 구현체를 자동으로 주입받음
    @Autowired
    private UserMapper userMapper;

    // 모든 사용자의 정보를 UserDTO 리스트로 반환
    public List<UserDTO> getAllUsers() {
        // ver1.
        List<User> users = userMapper.findAll(); // 모든 User 객체 가져옴
        List<UserDTO> userDTOs = new ArrayList<>(); // 새로운 DTO 객체 생성

        for (User user : users) { // for 루프를 사용하여 각 User 객체를 UserDTO 로 변환하고 리스트에 추가
            UserDTO userDTO = convertToDto(user);
            userDTOs.add(userDTO);
        }

        return userDTOs; // UserDTO 리스트 반환

        // ver2. Use Stream, map, collect
        //return userMapper.findAll().stream()
        //        .map(this::convertToDto)
        //        .collect(Collectors.toList());
    }

    // 특정 ID 의 사용자 정보를 UserDTO 로 반환
    public UserDTO getUserById(Long id) {
        User user = userMapper.findById(id);
        return convertToDto(user);
    }

    // 새 사용자 생성
    public void createUser(UserDTO userDto) {
        User user = convertToEntity(userDto);
        userMapper.insert(user);
    }

    // 사용자 정보 업데이트
    public void updateUser(UserDTO userDto) {
        User user = convertToEntity(userDto);
        userMapper.update(user);
    }

    // 특정 ID 의 사용자 삭제
    public void deleteUser(Long id) {
        userMapper.delete(id);
    }

    // User to UserDTO
    private UserDTO convertToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setNo((int) (user.getId() + 100));

        return dto;
    }

    // UserDTO to User
    private User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        return user;
    }

    // 참고. domain.User 와 dto.UserDTO 를 서로 변환하는 이유
    // - domain.User 는 데이터베이스 엔티티를 표현, 영속성 계층과 연관
    // - dto.UserDTO 는 클라이언트와 데이터 전송에 사용되며, 표현 계층과 연관
    //    DTO 사용시 클라이언트의 요구사항에 맞춰 데이터 구조를 쉽게 변경 가능
    //    필요한 데이터만 클라이언트에 전송하여 네트워크 부하 줄일 수 있음
    //    API 버전 관리 용이 (엔티티 변경 시 DTO 를 통해 이전 버전과의호환성 유지 가능)

}

// 서비스 계층을 사용하는 이유?
// 1. 관심사의 분리
//   - 비즈니스 로직을 컨트롤러와 데이터 액세스 계층에서 분리
//   - 각 계층의 책임을 명확히 하여 코드의 구조화와 유지보수를 용이하게 함
// 2. 재사용성
//   - 비즈니스 로직을 여러 컨트롤러에서 재사용 가능
// 3. 트랜잭션 관리
//   - 서비스 계층에서 트랜잭션을 관리하면 데이터 일관성을 보장하기 쉬움
// 4. 추상화
//   - 복잡한 비즈니스 로직을 추상화하여 컨트롤러를 더 간결하게 유지 가능
// 5. DTO 변환
//   - 엔티티와 DTO 간의 변환을 담당하여 계층간 데이터 전송을 관리
// 6. 확장성
//   - 새로운 기능이나 비즈니스 규칙을 추가할 때 서비스 계층만 수정하면 되므로 확장이 용이