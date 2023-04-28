package com.user.controller;

import com.user.entity.User;
import com.user.model.UserResponce;
import com.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserResponce getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment UserController");
        return userService.getUserWithDepartment(userId);
    }
}
