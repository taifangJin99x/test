package com.example.demo.com.by.factory;

import org.springframework.stereotype.Service;

@Service
public class NotificationMessageProcessor implements MessageProcessor{
    private final MessageProcessorFactory messageProcessorFactory;
    public NotificationMessageProcessor(MessageProcessorFactory messageProcessorFactory) {
        this.messageProcessorFactory = messageProcessorFactory;
        this.messageProcessorFactory.registerMessageProcessor(MessageEndPoint.NOTIFICATION, this);
    }

    @Override
    public void processMessage(Message message) {
        System.out.println("NotificationMessageProcessor");
    }
}
