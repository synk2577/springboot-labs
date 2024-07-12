package spring_labs.spring_boot_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMybatisApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisApplication.class, args);
	}

}

// 작업 순서
// 1. 설정 파일에서 mybatis 로드
// 		- build.gradle 에 dependencies 항목 추가
// 		- application.properties 설정 코드 추가
// 2. 로컬 Database 에서 Table 생성
// 3. controller -> service -> mapper -> xml
// 		- controller
// 		- service
// 		- mapper
// 		- xml


// MyBatis 동작 원리 (쉽게 정리해보자!)
// 1. 애플리케이션 동작
// 2. application.properties 설정 파일 참고해 DB 연결
// 3. mapper 실행하면 설정한 것을 토대로 connection 해서 SQL 실행 -> 결과 값을 객체에 매핑