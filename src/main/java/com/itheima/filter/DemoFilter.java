package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override//初始化方法
    public void init(FilterConfig filterConfig) throws ServletException{
        //System.out.println("initialize Filter");
        Filter.super.init(filterConfig);
    }
    @Override//拦截到请求后调用
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException,ServletException {
        //System.out.println("access Filter");
        chain.doFilter(request,response);
    }
    @Override//销毁方法
    public void destroy(){
        //System.out.println("Filter destroied");
        Filter.super.destroy();
    }
}
