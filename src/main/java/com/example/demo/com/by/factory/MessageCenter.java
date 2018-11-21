package com.example.demo.com.by.factory;

import com.example.demo.com.by.factory.domain.Message;
import com.example.demo.com.by.factory.factory.MessageProcessorFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class MessageCenter implements MessageCenterService{
    private final MessageProcessorFactory messageProcessorFactory;

    public MessageCenter(MessageProcessorFactory messageProcessorFactory) {
        this.messageProcessorFactory = messageProcessorFactory;
    }

    public void   dispatchMessage() {
        Message message = new Message();
        message.setEndPoint("NOTIFICATION");
        Collection<MessageProcessor> messageProcessors = messageProcessorFactory.getMessageProcessors(message.getEndPoint());
        if (null == messageProcessors || messageProcessors.isEmpty()) {

        }
        messageProcessors.forEach(messageProcessor -> {
            try {
                messageProcessor.processMessage(message);
            } catch (Exception ex) {
                System.out.println("MessageProcessor send message error: {}"+ messageProcessor.getClass().getSimpleName());
            }
        });
    }


}
