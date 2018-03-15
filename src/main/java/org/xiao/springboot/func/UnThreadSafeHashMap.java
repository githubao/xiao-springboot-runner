package org.xiao.springboot.func;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 测试map的多线程
 * hashMap 是链表的实现，rehash的时候，会丢掉其他线程的值
 *
 * Test-1
 * class:java.util.Hashtable, map size: 500000
 * class:java.util.HashMap, map size: 492050
 * class:java.util.concurrent.ConcurrentHashMap, map size: 500000
 * class:java.util.Collections$SynchronizedMap, map size: 500000
 * Test-2
 * class:java.util.Hashtable, map size: 500000
 * class:java.util.HashMap, map size: 486797
 * class:java.util.concurrent.ConcurrentHashMap, map size: 500000
 * class:java.util.Collections$SynchronizedMap, map size: 500000
 * Test-3
 * class:java.util.Hashtable, map size: 500000
 *
 * 第三次的时候就死锁了...
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/15 15:34
 */

public class UnThreadSafeHashMap {
    private final Object lock = new Object();

    private static final int POOL_SIZE = 5;
//    private static final int MAX_NUM = 100000;
    private static final int MAX_NUM = 100;

    private Map<String, Integer> hashTable = new Hashtable<>();
    private Map<String, Integer> normalHashMap = new HashMap<>();
    private Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    private Map<String, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

    public void run() {
//        runSingle(hashTable);
        runSingle(normalHashMap);
//        runSingle(concurrentHashMap);
//        runSingle(synchronizedMap);
    }

    private void runSingle(Map<String, Integer> map) {
//        System.out.println(String.format("Test from %s", map.getClass().getName()));

        ExecutorService executors = Executors.newFixedThreadPool(POOL_SIZE);

        Future future = null;

        for (int i = 0; i < POOL_SIZE; i++) {
            int finalI = i + 1;
            future = executors.submit(() -> {
                for (int j = 0; j < MAX_NUM; j++) {
//                    double random = Math.ceil(Math.random() * MAX_NUM);
//                    synchronized(lock){
                        map.put(String.format("%s-%s", finalI, j), j);
//                    }
                }

            });


        }

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (future.isDone()) {
                executors.shutdown();
//                System.out.println("task down");
                break;
            }
        }

        try {
            executors.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("class:%s, map size: %s", map.getClass().getName(), map.size()));
//        System.out.println(map);
    }
}
