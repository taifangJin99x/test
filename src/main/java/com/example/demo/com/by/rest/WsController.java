package com.example.demo.com.by.rest;

import com.example.demo.com.by.DTO.RequestMessage;
import com.example.demo.com.by.DTO.ResponseMessage;
import com.example.demo.com.by.factory.MessageCenterService;
//import com.example.demo.com.by.factoryTwo.ChannelInterface;
import com.example.demo.com.by.factoryTwo.MessageCenterServiceTwo;
import com.example.demo.com.by.factoryTwo.MessageQueueTwo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class WsController {
    private  final MessageCenterService messageCenter;
    private  final MessageCenterServiceTwo messageCenterServiceTwo;
    private final MessageQueueTwo messageQueueTwo;
    public WsController(MessageCenterService messageCenter, MessageCenterServiceTwo messageCenterServiceTwo, MessageQueueTwo messageQueueTwo) {
        this.messageCenter = messageCenter;

        this.messageCenterServiceTwo = messageCenterServiceTwo;
        this.messageQueueTwo = messageQueueTwo;
    }


    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        return new ResponseMessage("welcome," + message.getName() + " !");
    }

    @RequestMapping("/sendMessage")
    public String hello() {
        messageCenter.dispatchMessage();
        return "aa";
    }

    @RequestMapping("/sendMessageTwo")
    public String sendMessageTwo() {
        List<String> list = new ArrayList<>();
        list.add("EMAIL");
        list.add("SMS");
        for (int i = 0;i<=100;i++) {
            Collections.shuffle(list);
            messageQueueTwo.setQueue(list.get(0));
        }
        return "aa";
    }
}