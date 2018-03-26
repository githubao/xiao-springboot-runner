package org.xiao.springboot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * subject 被调用的时候的 动态处理类
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/26 16:24
 */

public class SubjectInvocationHandler implements InvocationHandler {

    private Object delegete;

    public SubjectInvocationHandler(Object delegete) {
        this.delegete = delegete;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();

        method.invoke(delegete, args);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(String.format("process time: %s", (end - start)));

        return null;
    }
}
