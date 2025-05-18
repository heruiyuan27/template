package com.template.aop;

import com.template.model.req.StringIdReq;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // 定义切入点
    @Pointcut("execution(* com.template.controller.TestController.postTest3(..))")
    public void serviceMethodPointcut() {
    }

    // 前置通知
    @Before("serviceMethodPointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("开始执行方法: {}", methodName);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof StringIdReq) {
                String id = ((StringIdReq) arg).getId();
                logger.info("截取StringIdReq:id={}", id);
            }
        }

    }

    // 后置通知
    @After("serviceMethodPointcut()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("方法执行完成: {}", methodName);
    }

    // 环绕通知
    @Around("serviceMethodPointcut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("方法执行时间: {}ms", (endTime - startTime));
        return result;
    }

    // 异常通知
    @AfterThrowing(pointcut = "serviceMethodPointcut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        logger.error("方法{}执行异常: {}", methodName, ex.getMessage());
    }
}
