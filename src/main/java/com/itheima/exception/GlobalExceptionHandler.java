package com.itheima.exception;

import com.itheima.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice//全局异常处理器 类 = @ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)//指定当前方法捕获什么类型的异常
    public Result ex(Exception e){
        e.printStackTrace();
        return Result.error("WRONG");
    }
}
