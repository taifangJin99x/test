package com.example.demo.com.by.factory;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class MessageProcessorFactory {
    private Map<MessageEndPoint, Set<MessageProcessor>> messageProcessors = new EnumMap<>(MessageEndPoint.class);
    private Set<MessageProcessor> defaultMessageProcessors = new LinkedHashSet<>();
    public MessageProcessorFactory(){}

    public synchronized void registerMessageProcessor(MessageEndPoint endPoint, MessageProcessor messageProcessor) {

//        Set<MessageProcessor> messageProcessorSet = new HashSet<>();
//        messageProcessorSet.add(messageProcessor);
//        messageProcessors.computeIfAbsent(endPoint, k -> messageProcessorSet);

        Set<MessageProcessor> set = messageProcessors.computeIfAbsent(endPoint,k->new LinkedHashSet<>());
        if (null != set)
            set.add(messageProcessor);

    }
    public synchronized void registerDefaultMessageProcessor(MessageProcessor messageProcessor) {
        this.defaultMessageProcessors.add(messageProcessor);
    }
    public Collection<MessageProcessor> getMessageProcessors(String endPoint) {

        try {
            MessageEndPoint mep = MessageEndPoint.valueOf(endPoint.toUpperCase());
            return messageProcessors.getOrDefault(mep, defaultMessageProcessors);
        } catch (Exception ex) {
            return defaultMessageProcessors;
        }
    }
}
