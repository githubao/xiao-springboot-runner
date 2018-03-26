package org.xiao.springboot.proxy;

/**
 * 真正做事的类
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/26 16:27
 */

public class RealSubject implements Subject {
    @Override
    public void doTask(String name) {
        System.out.println(String.format("%s do task: %s", this.getClass(), name));
    }
}
