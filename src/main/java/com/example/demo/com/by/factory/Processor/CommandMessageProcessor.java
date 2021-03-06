package com.example.demo.com.by.factory.Processor;

import com.example.demo.com.by.factory.domain.Message;
import com.example.demo.com.by.factory.MessageEndPoint;
import com.example.demo.com.by.factory.factory.MessageProcessorFactory;
import com.example.demo.com.by.factory.MessageProcessor;
import org.springframework.stereotype.Service;

@Service
public class CommandMessageProcessor implements MessageProcessor {
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
