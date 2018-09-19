package com.example.demo.com.by.factoryTwo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ChannelServiceFactory{
    private Map<String, ChannelService> managedChannelServices = new HashMap<>();
    public ChannelServiceFactory(List<ChannelService> list) {
        list.stream().forEach(f->{

            String channelServiceName = f.getClass().getSimpleName();
            String channelName = channelServiceName.replace("ChannelService","").toUpperCase();
            managedChannelServices.put(channelName,f);
        });
    }


    public void sendMessage() {
        managedChannelServices.get("EMAIL").sendMessage();
        managedChannelServices.get("SMS").sendMessage();

    }
}
