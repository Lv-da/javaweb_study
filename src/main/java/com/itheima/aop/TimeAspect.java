//package com.itheima.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
////aop:面向切面编程
//@Slf4j
//@Component
//@Aspect//当前类是一个aop类
//public class TimeAspect {
//    @Around("execution(* com.itheima.service.*.*(..))")
//    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        long begin=System.currentTimeMillis();//记录开始时间
//        Object object=proceedingJoinPoint.proceed();//调用原始方法运行
//        long end=System.currentTimeMillis();//记录结束时间
//        log.info(proceedingJoinPoint.getSignature()+"执行耗时：{}ms",end-begin);
//        System.out.println("执行耗时："+(end-begin)+"ms");
//        return object;//原始方法的返回值
//    }
//}
