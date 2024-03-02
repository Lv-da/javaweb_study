package com.itheima.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean//配置第三方bean
    public SAXReader saxReader(){//不指定名称默认为方法名/用@Bean中的name或value声明bean名称
        return new SAXReader();
    }
}
