package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//分页查询结果分装类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    //属性与接口文档对应
    private Long total;//总记录数
    private List rows;//当前页数据列表
}
