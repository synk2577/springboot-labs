CREATE DATABASE spring_labs DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

USE spring_labs;

-- users 테이블 생성
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 샘플 데이터 삽입
INSERT INTO users (username, email) VALUES
    ('john_doe', 'john.doe@example.com'),
    ('jane_smith', 'jane.smith@example.com'),
    ('bob_johnson', 'bob.johnson@example.com');

SELECT * FROM users;
