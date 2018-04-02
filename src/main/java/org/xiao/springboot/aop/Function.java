package org.xiao.springboot.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一个注解
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/2 17:13
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Function {
    String value() default "";
}
