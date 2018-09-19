package com.example.demo.com.by.factory;

import org.springframework.stereotype.Service;

@Service
public class CommandMessageProcessor implements MessageProcessor{
    private final MessageProcessorFactory messageProcessorFactory;
    public CommandMessageProcessor(MessageProcessorFactory messageProcessorFactory) {

        this.messageProcessorFactory = messageProcessorFactory;
        messageProcessorFactory.registerMessageProcessor(MessageEndPoint.COMMAND, this);
    }

    @Override
    public void processMessage(Message message) {
        System.out.println("CommandMessageProcessor");
    }
}
