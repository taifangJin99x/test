package com.example.demo.com.by.factory.Processor;

import com.example.demo.com.by.factory.domain.Message;
import com.example.demo.com.by.factory.MessageEndPoint;
import com.example.demo.com.by.factory.MessageProcessor;
import com.example.demo.com.by.factory.factory.MessageProcessorFactory;
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
