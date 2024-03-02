package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.entity.Result;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override//目标资源方法运行前运行，返回true放行，反之不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取请求URL
        String url=request.getRequestURL().toString();
        log.info("url:{}",url);
        //是否包含login
        if(url.contains("login")){
            log.info("登录操作，放行...");
            return true;
        }//可以在配置类中使用.excludePathPatterns("/login")
        //获取请求头中的token
        String token = request.getHeader("token");
        //判断令牌是否存在
        if(!StringUtils.hasLength(token)){
            log.info("Not login");
            Result error=Result.error("NOT_LOGIN");
            String jsonString = JSONObject.toJSONString(error);
            response.getWriter().write(jsonString);
            return false;
        }
        //校验令牌
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析错误");
            Result error=Result.error("NOT_LOGIN");
            String jsonString = JSONObject.toJSONString(error);
            response.getWriter().write(jsonString);
            return false;
        }
        //放行
        log.info("令牌合法");
        return true;
    }

    @Override//目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override//视图渲染完成后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
