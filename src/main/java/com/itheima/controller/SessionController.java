package com.itheima.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {
    @GetMapping("/c1")
    public void cookie1(HttpServletResponse response){
        response.addCookie(new Cookie("username","this is cookie"));
    }

    @GetMapping("/c2")
    public void cookie2(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("username"))
                System.out.println("username:"+cookie.getValue());
        }
    }

    @GetMapping("/s1")
    public void session1(HttpSession session){
        System.out.println("s1:"+session.hashCode());
        session.setAttribute("username","this is session");
    }

    @GetMapping("/s2")
    public void session2(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println("s1:"+session.hashCode());
        Object username=session.getAttribute("username");
        System.out.println("username:"+username);
    }
}
