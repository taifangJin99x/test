package com.example.demo.com.by.rest;

import com.example.demo.com.by.DTO.RequestMessage;
import com.example.demo.com.by.DTO.ResponseMessage;
import com.example.demo.com.by.factory.MessageCenterService;
//import com.example.demo.com.by.factoryTwo.ChannelInterface;
import com.example.demo.com.by.factoryTwo.MessageCenterServiceTwo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WsController {
    private  final MessageCenterService messageCenter;
    private  final MessageCenterServiceTwo messageCenterServiceTwo;

    public WsController(MessageCenterService messageCenter, MessageCenterServiceTwo messageCenterServiceTwo) {
        this.messageCenter = messageCenter;

        this.messageCenterServiceTwo = messageCenterServiceTwo;
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
        messageCenterServiceTwo.sendMessage();
        return "aa";
    }
}