package org.xiao.springboot.anno;

import java.lang.annotation.*;

/**
 * 示例注解
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/26 15:28
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Repeatable(MyAnnotations.class)
//@Documented
//@Inherited
public @interface MyAnnotation {
    int id() default 18;

    String name() default "xiao";
}
