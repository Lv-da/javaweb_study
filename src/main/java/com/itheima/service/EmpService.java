package com.itheima.service;

import com.itheima.entity.Emp;
import com.itheima.entity.Login;
import com.itheima.entity.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean page(Integer page, Integer pageSize);

    PageBean pageHelper(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Login login);
}
