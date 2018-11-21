package com.example.demo.com.by.factoryTwo;

import com.example.demo.com.by.factoryTwo.factory.ChannelServiceFactory;
import com.example.demo.com.by.factoryTwo.queue.MessageQueueTwo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class MessageCenterTwo implements MessageCenterServiceTwo, InitializingBean {
    private final ChannelServiceFactory channelServiceFactory;
    private final MessageQueueTwo messageQueueTwo;

    public MessageCenterTwo(ChannelServiceFactory channelServiceFactory, MessageQueueTwo messageQueueTwo) {
        this.channelServiceFactory = channelServiceFactory;
        this.messageQueueTwo = messageQueueTwo;
    }

    @Valid
    public void sendMessage(String queue) {

        channelServiceFactory.sendMessage(queue);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (int i = 0; i < 3; i++) {
            new MessageProcessThread().start();
        }
    }

    private class MessageProcessThread extends Thread {
        @Override
        public void run() {
            String queue = null;
            while (!Thread.interrupted()) {
                try {
                    queue = messageQueueTwo.getQueue();
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        Thread.sleep(1000 * 6);
                    } catch (InterruptedException e1) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (null != queue) {
                    MessageCenterTwo.this.sendMessage(queue);
                } else {
                    try {
                        Thread.sleep(1000 * 6);
                    } catch (InterruptedException e1) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

}
