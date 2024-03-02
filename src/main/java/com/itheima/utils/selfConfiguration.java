package com.itheima.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "testuser.test")
public class selfConfiguration {
//    @Value("${self.test}")//读取配置文件属性
//    private String test;//将属性提前写入配置文件
    private String name;
    private Integer age;
    private List<String> hobby;
}
