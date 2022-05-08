package com.post_user_service.controller;

import com.post_user_service.dto.UserDto;
import com.post_user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto postMapping(@RequestBody UserDto user) {
        return userService.postUser(user);
    }
}
