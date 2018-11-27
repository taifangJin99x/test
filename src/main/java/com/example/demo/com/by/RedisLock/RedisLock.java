package com.example.demo.com.by.RedisLock;

import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class RedisLock implements Lock{


    ThreadLocal<Jedis> threadLocal = new ThreadLocal<>();
    static String LOCK_NAME = "LOCK_NAME";

    @Override
    public void lock() {
        if (threadLocal.get() == null){
            Jedis jedis = new Jedis("127.0.0.1");
            threadLocal.set(jedis);
        }
        while (true) {
            if (tryLock()){
                System.out.println(Thread.currentThread().getName() + "加锁成功");
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                return;
            }else {
                System.out.println(Thread.currentThread().getName() + "等待锁");

            }
        }

    }

    @Override
    public boolean tryLock() {
//        long result =  threadLocal.get().setnx(LOCK_NAME,"1");
//        if (1 == result) {
//            threadLocal.get().expire(LOCK_NAME,1000);
//            return true;
//        }
        String result = threadLocal.get().set(LOCK_NAME,"1","NX","PX",1000);
        if (null != result && result.equals("OK")){
            return true;
        }
        return false;
    }

    @Override
    public void unlock() {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        System.out.println(Thread.currentThread().getName() + "解锁成功");
        threadLocal.get().eval(script, Collections.singletonList(LOCK_NAME), Collections.singletonList("1"));

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }

}
