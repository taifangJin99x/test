package com.example.demo.com.by.factoryTwo.processor;

import com.example.demo.com.by.factoryTwo.ChannelService;
import org.springframework.stereotype.Component;

@Component
public class EmailChannelService implements ChannelService {
    @Override
    public void sendMessage() {
        System.out.println("EmailChannelService");
    }
}
