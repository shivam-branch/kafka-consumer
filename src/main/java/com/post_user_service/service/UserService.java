package com.post_user_service.service;


import com.post_user_service.dto.UserDto;
import com.post_user_service.entity.User;
import com.post_user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDto postUser(UserDto userDto){
        User u = User.builder()
                .key(UUID.randomUUID().toString())
                .name(userDto.getName())
                .status(userDto.getStatus())
                .build();
        User user = userRepository.save(u);
        return UserDto.builder()
                .key(user.getKey())
                .name(user.getName())
                .status(user.getStatus())
                .build();

    }
}
