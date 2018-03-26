package org.xiao.springboot.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 多个注解
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/26 15:56
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface MyAnnotations {
    MyAnnotation[] value();
}
