package com.example.demo.com.by.RedisLock;

import org.apache.zookeeper.*;

import java.io.IOException;

public class ZkTest {
    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("localhost:8081",3000,(watchedEvent -> {}));

        //持久节点
//        zk.create("/luban","zhouyu".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        //临时节点
       //zk.create("/luban_EPHEMERAL","zhouyu".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL);
        //持久有序节点
//        zk.create("/luban_","zhouyu".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT_SEQUENTIAL);
//        zk.create("/luban_","zhouyu".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT_SEQUENTIAL);
        //临时顺序节点
//        String one = zk.create("/luban_LINSHI","zhouyu".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
//        String two = zk.create("/luban_LINSHI","zhouyu".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);
//        System.out.println(one+":"+two);
        boolean re = true;
            zk.exists("/ep_node", new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    Event.EventType eventType = watchedEvent.getType();
                    if (Event.EventType.NodeDeleted.equals(eventType)) {
                        System.out.println("节点被删除");
                        return;
                    }
                }
            });

    }
}
