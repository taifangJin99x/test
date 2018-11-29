package com.example.demo.com.by.RedisLock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.awt.*;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.stream.Collectors;

public class ZkLock implements Lock {
    private static String LOCK_NAME = "/LOCK";
    private ThreadLocal<ZooKeeper> zk = new ThreadLocal<ZooKeeper>();
    private ThreadLocal<String> CURRENT_LOCK = new ThreadLocal<>();

    @Override
    public void lock() {
        init();
        if (tryLock()) {
            System.out.println(Thread.currentThread().getName() + "获取到了锁");
        }
    }

    private void init() {
        if (zk.get() == null) {
            try {
                zk.set(new ZooKeeper("localhost:8081", 3000, new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {

                    }
                }));
//                Stat stat = zk.get().exists(LOCK_NAME,false);
//                if (stat == null){
//                    zk.get().create(LOCK_NAME,new byte[0],ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
//                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    @Override
    public boolean tryLock() {
        //由于临时节点名称
        String nodeName = LOCK_NAME + "/zk_";
        try {
            //set节点，并把节点名字赋值给CURRENT_LOCK
            // 因为是临时节点，多个线程会生成有序节点
            CURRENT_LOCK.set(zk.get().create(nodeName, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL));
            //获取到所有子节点
            List<String> nodeList = zk.get().getChildren(LOCK_NAME, false);
//            TimeUnit.SECONDS.sleep(1);

            Collections.sort(nodeList);
            System.out.println(nodeList);
            //取出来第一个
            String minNode = nodeList.get(0);
            System.out.println(Thread.currentThread().getName() + "当前节点是" + CURRENT_LOCK.get());
            if (CURRENT_LOCK.get().equals(LOCK_NAME + "/" + minNode)) {
                //如果当前节点是最小节点
                return true;
            } else {
                //等待锁
                System.out.println(Thread.currentThread().getName() + "等待锁");
                //获取上一个节点并监听该节点
                String prevNode = nodeList.get(nodeList.indexOf(CURRENT_LOCK.get().substring(CURRENT_LOCK.get().lastIndexOf("/") + 1))-1);

                Stat prevExist = zk.get().exists(LOCK_NAME + "/" + prevNode, (watchedEvent -> {
                    //监听到上一个节点被删除，唤醒锁
                    if (Watcher.Event.EventType.NodeDeleted.equals(watchedEvent.getType())) {
                        System.out.println(Thread.currentThread().getName() + "唤醒锁");
                    }
                }));
                //如果有上一个节点则等待
                if (prevExist != null) {
                    //阻塞
                    Thread.sleep(1000);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public void unlock() {
        try {
            System.out.println(Thread.currentThread().getName() + "删除锁" + CURRENT_LOCK.get());
            zk.get().delete(CURRENT_LOCK.get(), -1);
            CURRENT_LOCK.remove();
            zk.get().close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

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
