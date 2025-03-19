package com.iiht.training.blogs.controller;

import com.iiht.training.blogs.entity.User;
import com.iiht.training.blogs.repository.UserRepository;
import com.iiht.training.blogs.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User foundUser  = userRepository.findByUsername(user.getUsername());
        if (foundUser  != null && foundUser .getPassword().equals(user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        throw new RuntimeException("Invalid credentials");
    }
}
