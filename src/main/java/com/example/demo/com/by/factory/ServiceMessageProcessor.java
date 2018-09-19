package com.example.demo.com.by.factory;

import org.springframework.stereotype.Service;

@Service
public class ServiceMessageProcessor implements MessageProcessor {
    private final MessageProcessorFactory messageProcessorFactory;

    public ServiceMessageProcessor(MessageProcessorFactory messageProcessorFactory) {
        this.messageProcessorFactory = messageProcessorFactory;
        messageProcessorFactory.registerMessageProcessor(MessageEndPoint.MESSAGE, this);
        messageProcessorFactory.registerDefaultMessageProcessor(this);
    }

    @Override
    public void processMessage(Message message) {
        System.out.println("ServiceMessageProcessor");
    }
}
