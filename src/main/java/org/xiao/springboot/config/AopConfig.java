package org.xiao.springboot.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * aop 配置
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/3 11:41
 */

@Configuration
@Aspect
public class AopConfig {

    @Around("within(@org.springframework.web.bind.annotation.RestController *)")
    public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs();
        System.out.println("args: "+ Arrays.asList(args));
        Object o = pjp.proceed();
        System.out.println("result: "+o);
        return o;
    }

}
