package com.example.demo.com.by.factory;

public interface MessageProcessor {
    /**
     * 发送消息
     *
     * @param message 消息体
     */
    void processMessage(Message message);
}
