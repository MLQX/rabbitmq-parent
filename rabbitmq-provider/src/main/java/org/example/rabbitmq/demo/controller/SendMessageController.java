package org.example.rabbitmq.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class SendMessageController {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/sendMsg")
    public void sendMsg(){
        String messageId = UUID.randomUUID().toString();
        String messageData = "test massage send";
        String messageTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, String> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("messageTime", messageTime);
        rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting",map);
    }



}
