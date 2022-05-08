package com.post_user_service.service;

import com.post_user_service.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerService {

    private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);


    private final UserService userService;

    @Autowired
    public ConsumerService(UserService userService){
        this.userService = userService;
    }


    @KafkaListener(topics = "${general.topic.name}",
            groupId = "${general.topic.group.id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(UserDto message) throws IOException {
        logger.info(String.format("Message recieved -> %s", message));
        userService.postUser(message);
    }
}
