package com.codegym.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    int count = 0;

    @Pointcut("within(com.codegym.controller.BookController*)")
    public void addMethodPointCut() {
    }

    @Around("addMethodPointCut()")
    public Object aroundCallMethod(ProceedingJoinPoint proceedingJoinPoint) {
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        count++;
        System.err.println("method:" + value + " số lượng người đã ghé thăm thư viện sách:" + count);
        return value;
    }

    @Pointcut("execution(* com.codegym.controller.BookController.updateBook(..))")
    public void updateBookPointCut() {
    }

    @AfterReturning("updateBookPointCut()")
    public void borrowBook(JoinPoint joinPoint) {
        System.err.println("method:" + joinPoint.getSignature().getName() +
                " class name:" + joinPoint.getSignature().getDeclaringTypeName());
    }

    @Pointcut("execution(* com.codegym.controller.BookController.payBook(..))")
    public void payBookPointCut() {
    }

    @AfterReturning("payBookPointCut()")
    public void payBook(JoinPoint joinPoint) {
        System.err.println("method:" + joinPoint.getSignature().getName() +
                " class name:" + joinPoint.getSignature().getDeclaringTypeName());
    }
}
