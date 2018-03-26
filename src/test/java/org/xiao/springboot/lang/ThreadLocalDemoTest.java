package org.xiao.springboot.lang;

import org.junit.Test;

/**
 * thread local
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/15 17:40
 */

public class ThreadLocalDemoTest {

    @Test
    public void testThreadLocal(){
        ThreadLocalDemo demo = new ThreadLocalDemo();
        demo.run();
    }
}