package com.example.fantasy.fantasyleague.controller;

import com.example.fantasy.fantasyleague.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id){
        return userService.get(id);
    }
}
