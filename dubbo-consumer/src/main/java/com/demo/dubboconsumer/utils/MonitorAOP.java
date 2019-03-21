package com.demo.dubboconsumer.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP 日志
 */
@Aspect
@Component
@Slf4j
public class MonitorAOP {

    @Autowired
    private HttpServletRequest request;

    @Pointcut("execution(* com.demo.dubboconsumer.controller..*.*(..))")
    public void aspect(){}

    @Around("aspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info(joinPoint + "|Time-Consuming:" + (end-start) + "|" + request.getRequestURI());
        return result;
    }

    @AfterThrowing(value = "aspect()", throwing = "e")
    public void afterException(JoinPoint joinPoint, Exception e){

    }
}