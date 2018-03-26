package org.xiao.springboot.lang;

import org.junit.Test;


/**
 * 测试
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/15 15:46
 */

public class UnThreadSafeHashMapTest {

    @Test
    public void testMap() {

        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("Test-%s", i + 1));
            UnThreadSafeHashMap unThreadSafeHashMap = new UnThreadSafeHashMap();
            unThreadSafeHashMap.run();
        }

    }
}