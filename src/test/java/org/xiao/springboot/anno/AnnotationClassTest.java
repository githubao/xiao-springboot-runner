package org.xiao.springboot.anno;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 注解测试
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/26 15:41
 */

public class AnnotationClassTest {

    @Test
    public void testAnno() {
        AnnotationClass instance = new AnnotationClass();
        instance.run();
    }

    @Test
    public void testAnnos() {
        AnnotationClass instance = new AnnotationClass("123");
        instance.run();
    }

}