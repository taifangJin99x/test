package LockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo implements Runnable {
    Integer thread = 100;
        @Override
    public void run() {
        synchronized (Demo.class) {
            while (thread > 0) {
                thread--;
                System.out.println(Thread.currentThread().getName() + "抢到一张还有" + thread + "张");

            }
        }
    }


    public static void main(String[] args){

        Demo demo = new Demo();
        Thread thread1 = new Thread(demo, "s1");
        Thread thread2 = new Thread(demo, "s2");
        thread2.start();
        thread1.start();

    }
//    Lock lock = new ReentrantLock();
//    @Override
//    public void run() {
//        lock.lock();
//        try {
//            while (thread > 0) {
//                thread--;
//                System.out.println(Thread.currentThread().getName() + "抢到一张还有" + thread + "张");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
}
