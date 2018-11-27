package com.example.demo.com.by.RedisLock;

import java.util.concurrent.locks.Lock;

public class Main{
    public static void main(String[] args) {

        new Thread(new UserThread(),"threat1").start();
        new Thread(new UserThread(),"threat2").start();
        new Thread(new UserThread(),"threat3").start();

    }
    static Lock lock = new RedisLock();
    static class UserThread implements Runnable{

        @Override
        public void run() {
            new Order().createOrder();
            lock.lock();
            boolean result = new Stock().reduceStock();

            if (result){
                System.out.println(Thread.currentThread().getName()+"减去库存成功");
                new Payment().pay();
            }else {
                System.out.println(Thread.currentThread().getName()+"减去库存失败");
            }
            lock.unlock();
        }
    }

}
