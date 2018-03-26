package org.xiao.springboot.lang;

/**
 * 学习threadlocal
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/15 17:38
 */

public class ThreadLocalDemo {
    private static final int NUM = 5;

//    private static final ThreadLocal<String> local = ThreadLocal.withInitial(() -> Thread.currentThread().getName());

//    private static final ThreadLocal<String> local = ThreadLocal.withInitial(() -> "");

    private static final ThreadLocal<String> local = new InheritableThreadLocal<>();

    public void run() {
        Thread[] threads = new Thread[NUM];

        local.set(Thread.currentThread().getName());

        for (int i = 0; i < NUM; i++) {
            threads[i] = new Thread(
                    () -> {
//                        local.set(Thread.currentThread().getName());
                        System.out.println(local.get());
                    });
            threads[i].start();
        }

        for (int i = 0; i < NUM; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
