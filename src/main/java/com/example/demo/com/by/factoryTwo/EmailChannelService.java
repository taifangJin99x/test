package com.example.demo.com.by.factoryTwo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmailChannelService implements ChannelService {
    @Override
    public void sendMessage() {
        System.out.println("EmailChannelService");
    }
}
