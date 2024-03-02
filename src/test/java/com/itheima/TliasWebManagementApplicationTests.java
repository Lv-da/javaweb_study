package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itheima.utils.selfConfiguration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testUUID(){
        for (int i = 0; i < 1000; i++) {
            String uuid= UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    @Autowired
    private selfConfiguration selfConfiguration;

    @Test
    public void testConfiguration(){
        System.out.println(selfConfiguration);
    }

    @Test
    public void testJwt(){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","kwt");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "itheima")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void parseJwt(){
        Claims itheima = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoia3d0IiwiaWQiOjEsImV4cCI6MTcwMDU4MDI4Mn0.NllDmsp-D9XXNLeEstKhX-21Zhv7Kg_0soQByB4E66c")
                .getBody();
        System.out.println(itheima);
    }

}
