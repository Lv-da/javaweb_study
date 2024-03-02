//package com.itheima.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
////不同切面类的运行顺序默认按照类名的字符串排序，先进后出，可用@Order排序
////在Spring中用JoinPoint抽象了连接点，用它可以获得方法执行时的相关信息，如目标类名、方法名、方法参数等
////》对于@Around 通知，获取连接点信息只能使用 ProceedingJoinPoint
////》对于其他四种通知，获取连接点信息只能使用 JoinPoint ，它是 ProceedingJoinPoint 的父类型
////@Component
//@Slf4j
////@Aspect
//public class DemoAspect {
//    //切入点表达式：描述切入点方法的一种表达式，决定项目中哪些方法需要加入通知
//    //1. execution(...)根据方法的签名来匹配
//    //execution(访问修饰符? 返回值 包名.类名.?方法名(方法参数) throws 异常?)
//    //访问修饰符?,  包名.类名.?, throws 异常? 可以省略
//    //@Around("execution(* com.itheima.service.*.*(..))")
//    //@PoingCut("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
//    //*：单个独立的任意符号，可以通配任意返回值、包名、类名、方法名、任意类型的一个参数，也可以通配包、类、方法名的一部分
//    //.. :多个连续的任意符号，可以通配任意层级的包，或任意类型、任意个数的参数
//    //可以@Pointcut( execution(...) || execution(...) )    &&   !  同理
//    //2.@annotation(...)根据注解匹配
//    //@Pointcut("@annotation(com.itheima.anno.MyLog)")
//    //@Pointcut("")//切入点表达式，将公共的切入点表达式抽取出来，可以被引用
//    private void pt(){}
//
//    //环绕通知@Around需要自行调用ProceedingJoinPoint.proceed()来让原始方法执行
//    //其它通知不需要考虑目标方法执行
//    //@Around环绕通知方法的返回值，必须指定为Object，来接收原始方法的返回值
//
//    //@Before("pt()")
//    public void before(){
//        log.info("before");
//    }
//
//    //@Around("")
//    public void around(){
//        log.info("around");
//    }
//
//    //@After("")
//    public void after(){
//        log.info("after");
//    }
//
//    //@AfterReturning
//    public void afterReturning(){
//        log.info("afterReturning");
//    }
//
//    //@AfterThrowing
//    public void afterThrowing(){
//        log.info("afterThrowing");
//    }
//}
