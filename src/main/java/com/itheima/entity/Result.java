package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {//restful，rest风格的接口，统一响应结果
    private Integer code;//响应码，1成功，0失败
    private String msg;//响应信息 描述字符串
    private Object data;//返回的数据 响应体

    public static Result success() {//增删改 成功响应
        return new Result(1, "success", null);
    }

    public static Result success(Object data) {//查询 成功响应
        return new Result(1, "success", data);
    }

    public static Result error(String msg) {//失败响应
        return new Result(0, msg, null);
    }

    //开发流程：
    //查看页面原型/明确需求 -> 阅读接口文档 -> 思路分析 -> 接口开发 -> 接口测试 -> 前后端联调
}