package com.itheima.service;

import com.itheima.entity.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();
    void deleteById(Integer id);
    void insert(Dept dept);
    Dept getById(Integer id);
    void update(Dept dept);
}
