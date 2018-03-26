package org.xiao.springboot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 用于生成动态代理的工厂
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/26 16:26
 */

public class DynamicSubjectFactory {

    private DynamicSubjectFactory() {
    }

    public static Subject getInstance() {
        Subject delegate = new RealSubject();
        InvocationHandler handler = new SubjectInvocationHandler(delegate);

        Subject proxy = (Subject) Proxy.newProxyInstance(
                delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                handler
        );

        return proxy;
    }

}
