package com.hrp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author herenpeng
 * @since 2020-11-01 16:47
 */
@Aspect
@Component
public class LogAop {

    @Pointcut("execution(public * com.hrp.controller.*.*(..))")
    public void logAop() {
    }

    @Before("logAop()")
    public void doBefore() {
        System.out.println("[AOP]===================doBefore===================");
    }

    @AfterReturning("logAop()")
    public void doAfterReturning(JoinPoint joinPoint) {
        System.out.println("[AOP]===================doAfterReturning===================");
    }

    @AfterThrowing(value = "logAop()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("[AOP]===================doAfterThrowing===================");
    }

    @After("logAop()")
    public void doAfter() {
        System.out.println("[AOP]===================doAfter===================");
    }

    @Around("logAop()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("[AOP]===================doAround before===================");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("[AOP]===================doAround after===================");
        return result;
    }

}
