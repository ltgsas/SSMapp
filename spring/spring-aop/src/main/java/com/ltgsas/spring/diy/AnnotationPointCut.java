package com.ltgsas.spring.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 方式三：使用注解来实现 AOP
@Aspect //标注这是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.ltgsas.spring.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("－－－－方法执行前－－－－");
    }

    @After("execution(* com.ltgsas.spring.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("－－－－方法执行后－－－－");
    }

    // 在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点：
    @Around("execution(* com.ltgsas.spring.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前－－－");
        System.out.println(joinPoint.getSignature());
        Object proceed = joinPoint.proceed();
        System.out.println("－－－环绕后");
    }
}
