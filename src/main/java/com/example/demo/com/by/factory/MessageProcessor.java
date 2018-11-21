package com.example.demo.com.by.factory;

import com.example.demo.com.by.factory.domain.Message;

public interface MessageProcessor {
    /**
     * 发送消息
     *
     * @param message 消息体
     */
    void processMessage(Message message);
}
