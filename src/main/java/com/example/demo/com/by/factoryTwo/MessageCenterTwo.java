package com.example.demo.com.by.factoryTwo;

import org.springframework.stereotype.Service;

@Service
public class MessageCenterTwo implements MessageCenterServiceTwo{
    private final ChannelServiceFactory channelServiceFactory;

    public MessageCenterTwo(ChannelServiceFactory channelServiceFactory) {
        this.channelServiceFactory = channelServiceFactory;
    }

    public void sendMessage(){
        channelServiceFactory.sendMessage();
    }
}
