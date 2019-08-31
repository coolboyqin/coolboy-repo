package com.config;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyInterceptor {
    public Object round(ProceedingJoinPoint joinPoint) throws Throwable {

        long begin = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println(joinPoint+"/"+(end-begin));
        return proceed;
    }
}
