package com.itheima.controller;

import com.itheima.entity.Emp;
import com.itheima.entity.Login;
import com.itheima.entity.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Login login){
        log.info("登录：{}",login);
        Emp res = empService.login(login);
        if(res!=null){
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",res.getId());
            claims.put("name",res.getName());
            claims.put("username",res.getUsername());
            String jws = JwtUtils.generateJwt(claims);
            return Result.success(jws);
        }else {
            return Result.error("NOT_LOGIN");
        }
    }
}
