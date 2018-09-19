package com.example.demo.com.by.factoryTwo;

import org.springframework.stereotype.Component;

@Component

public class SMSChannelService implements ChannelService {
    @Override
    public void sendMessage() {
        System.out.println("SMSChannelService");
    }
}
