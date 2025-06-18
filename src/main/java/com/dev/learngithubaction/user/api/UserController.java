package com.dev.learngithubaction.user.api;

import com.dev.learngithubaction.user.domain.User;
import com.dev.learngithubaction.user.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello Docker World! Spring Boot와 MySQL이 Docker 컨테이너에서 실행 중입니다.";
    }

    @GetMapping("/health")
    public String health() {
        return "Spring Boot Application is running healthy with MySQL!";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/test-db")
    public String testDb() {
        User testUser = new User("Test User", "test@example.com");
        userRepository.save(testUser);
        long count = userRepository.count();
        return "데이터베이스 연결 성공! 총 사용자 수: " + count;
    }
}