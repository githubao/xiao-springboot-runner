package org.xiao.springboot.proxy;

/**
 * subject 的客户端的调用代码
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/26 16:29
 */

public class SubjectRunner {

    public static void run() {
        Subject subject = DynamicSubjectFactory.getInstance();
        subject.doTask("你好");
    }
}
