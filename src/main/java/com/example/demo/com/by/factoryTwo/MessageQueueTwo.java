package com.example.demo.com.by.factoryTwo;

import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
@Component
public class MessageQueueTwo {
    Queue<String> queue = new ArrayBlockingQueue<>(10000);

    public String getQueue(){
        return queue.poll();
    }
    public void setQueue(String que){
        queue.add(que);

    }
    public Integer getQueueNum(){

        return queue.size();
    }

}
