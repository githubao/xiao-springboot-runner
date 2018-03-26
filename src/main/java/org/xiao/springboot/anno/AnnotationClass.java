package org.xiao.springboot.anno;


/**
 * 被注解修饰的类
 * <p>
 * java8 新增了两种注解的类型， TYPE_PARAMETER 和 TYPE_USE
 *
 * @author pacman
 * @version 1.0
 * date: 2018/3/26 15:33
 */

@MyAnnotation(id = 1, name = "aaa")
@MyAnnotation(id = 2, name = "bbb")
public class AnnotationClass {

    public AnnotationClass() {
        MyAnnotation anno = this.getClass().getAnnotation(MyAnnotation.class);
        if (null != anno) {
            System.out.println(String.format("id %s, name %s started", anno.id(), anno.name()));
        }
    }

    public AnnotationClass(String s) {
        MyAnnotation[] annos = this.getClass().getAnnotationsByType(MyAnnotation.class);
        if (null != annos) {
            for (MyAnnotation anno : annos) {
                System.out.println(String.format("id %s, name %s started", anno.id(), anno.name()));
            }
        }
    }

    public void run() {

    }

}
