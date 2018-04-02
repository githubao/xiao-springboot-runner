package org.xiao.springboot.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.xiao.springboot.aop.Function;

/**
 * 配置类，控制用户的访问权限
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/2 17:14
 */

@Configuration
@Aspect
public class RoleAccessConfig {

//    @Around("within(@org.springframework.stereotype.Controller *) && @annotation(function)")
    @Around("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(function)")
    public Object functionAccessCheck(final ProceedingJoinPoint pjp, Function function) throws Throwable {
        if (function != null) {
            String functionName = function.value();
            if (!canAccess(functionName)) {
                MethodSignature ms = (MethodSignature) pjp.getSignature();
                throw new RuntimeException("Can not access " + ms.getMethod());
            }
        }

        return pjp.proceed();
    }

    private boolean canAccess(String functionName) {
        if (functionName.length() == 0) {
            return true;
        } else {
            return !functionName.equals("private");
        }
    }
}
