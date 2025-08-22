package com.example.bookstore.controller.user;

import com.example.bookstore.model.User;
import com.example.bookstore.service.UserService;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public User registration(User user) {
        return userService.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email, @RequestParam String password) {
        Optional<User> user = userService.findByEmailAndPassword(email, password);
        return user.orElseThrow(() -> new RuntimeException("Invalid credentials!"));
    }
}
