package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.entity.Emp;
import com.itheima.entity.Login;
import com.itheima.entity.PageBean;
import com.itheima.mapper.EmpMapper;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page,Integer pageSize){
        //获取总记录数
        Long count=empMapper.count();

        //获取分页查询结果列表
        Integer start = (page-1)*pageSize;
        List<Emp> rows = empMapper.page(start,pageSize);

        //封装
        PageBean pageBean = new PageBean(count,rows);

        return pageBean;
    }

    @Override
    public PageBean pageHelper(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize){
        //设置分页参数
        PageHelper.startPage(page,pageSize);

        //执行查询操作
        List<Emp> list=empMapper.getAll(name,gender,begin,end);
        Page<Emp> pages=(Page<Emp>)list;

        //封装
        PageBean pageBean = new PageBean(pages.getTotal(),pages.getResult());

        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids){
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp){
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public Emp getById(Integer id){
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp){
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Login login){
        Emp emp = empMapper.login(login);
        return emp;
    }
}
