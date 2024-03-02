package com.itheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.itheima.entity.OperateLog;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect//切面类
public class LogAspect {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Autowired
    private HttpServletRequest request;

//    @Around("execution(* com.itheima.controller.*.delete*(..)) || " +
//            "execution(* com.itheima.controller.*.add*(..)) ||" +
//            "execution(* com.itheima.controller.*.update*(..))")
//    @Before("@annotation(com.itheima.anno.MyLog)")
//    public void before(){
//        log.info("this is LogAspect");
//    }

    @Around("@annotation(com.itheima.anno.MyLog)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        OperateLog operateLog = new OperateLog();
        log.info("AOP记录操作日志：{}",operateLog);
        operateLog.setId(null);
        //获取用户id
        String jwt = request.getHeader("token");
        Claims claims= JwtUtils.parseJWT(jwt);
        operateLog.setOperateUser((Integer) claims.get("id"));
        //获取操作时间
        operateLog.setOperateTime(LocalDateTime.now());
        //获取类名
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        //获取方法名
        operateLog.setMethodName(joinPoint.getSignature().getName());
        //获取方法参数
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        //方法返回值
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        operateLog.setReturnValue(JSONObject.toJSONString(result));
        //操作耗时
        operateLog.setCostTime(end-begin);
        operateLogMapper.insert(operateLog);
        log.info("AOP记录操作日志：{}",operateLog);
        return result;
    }
}


////package com.itheima.aop;
////
////import com.alibaba.fastjson.JSONObject;
////import com.itheima.mapper.OperateLogMapper;
////import com.itheima.entity.OperateLog;
////import com.itheima.utils.JwtUtils;
////import io.jsonwebtoken.Claims;
////import jakarta.servlet.http.HttpServletRequest;
////import lombok.extern.slf4j.Slf4j;
////import org.aspectj.lang.ProceedingJoinPoint;
////import org.aspectj.lang.annotation.Around;
////import org.aspectj.lang.annotation.Aspect;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Component;
////
////import java.time.LocalDateTime;
////import java.util.Arrays;
////
////@Slf4j
////@Component
////@Aspect //切面类
////public class LogAspect {
////
////    @Autowired
////    private HttpServletRequest request;
////
////    @Autowired
////    private OperateLogMapper operateLogMapper;
////
////    @Around("@annotation(com.itheima.anno.MyLog)")
////    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
////        //操作人ID - 当前登录员工ID
////        //获取请求头中的jwt令牌, 解析令牌
////        String jwt = request.getHeader("token");
////        Claims claims = JwtUtils.parseJWT(jwt);
////        Integer operateUser = (Integer) claims.get("id");
////
////        //操作时间
////        LocalDateTime operateTime = LocalDateTime.now();
////
////        //操作类名
////        String className = joinPoint.getTarget().getClass().getName();
////
////        //操作方法名
////        String methodName = joinPoint.getSignature().getName();
////
////        //操作方法参数
////        Object[] args = joinPoint.getArgs();
////        String methodParams = Arrays.toString(args);
////
////        long begin = System.currentTimeMillis();
////        //调用原始目标方法运行
////        Object result = joinPoint.proceed();
////        long end = System.currentTimeMillis();
////
////        //方法返回值
////        String returnValue = JSONObject.toJSONString(result);
////
////        //操作耗时
////        Long costTime = end - begin;
////
////
////        //记录操作日志
////        OperateLog operateLog = new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime);
////        operateLogMapper.insert(operateLog);
////
////        log.info("AOP记录操作日志: {}" , operateLog);
////
////        return result;
////    }
////
////}
