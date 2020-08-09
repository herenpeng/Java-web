package com.hrp.aop;

import com.hrp.domain.Log;
import com.hrp.mapper.LogMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * AOP日志
 *
 * @author hrp
 * 2020/3/20 17:12
 */
@Aspect
@Component
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LogMapper logMapper;

    private Log log;

    @Pointcut("@annotation(com.hrp.annotation.ShopLog)")
    public void controllerAOP() {
    }

    @Before("controllerAOP()")
    public void doBefore() {
        log = new Log();
        log.setVisitTime(new Date());
    }

    @After("controllerAOP()")
    public void doAfter(JoinPoint joinPoint) {
        log.setExecutionTime(System.currentTimeMillis() - log.getVisitTime().getTime());
        log.setIp(request.getRemoteAddr());
        log.setUri(request.getRequestURI());
        log.setMethod("[类名]" + joinPoint.getTarget().getClass() + "[方法名]" + joinPoint.getSignature().getName());
    }

    @AfterReturning("controllerAOP()")
    public void doAfterReturning() {
        logMapper.insert(log);
    }

    @AfterThrowing(value = "controllerAOP()", throwing = "e")
    public void doException(Exception e) {
        log.setExceptionName(e.getClass().getName());
        log.setExceptionMessage(e.getMessage());
        logMapper.insert(log);
    }
}
