package com.example.demo.com.by.RedisLock;

public class Stock {
    private static  Integer COUNT = 2;

    public boolean  reduceStock(){
        if (COUNT > 0){
            COUNT--;
            return true;
        }
        return false;
    }
}
