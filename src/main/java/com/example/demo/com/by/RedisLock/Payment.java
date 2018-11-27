package com.example.demo.com.by.RedisLock;

public class Payment {
    public void pay(){
        System.out.println(Thread.currentThread().getName()+"支付成功");
    }
}
