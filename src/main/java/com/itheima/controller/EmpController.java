package com.itheima.controller;

import com.itheima.anno.MyLog;
import com.itheima.entity.Emp;
import com.itheima.entity.PageBean;
import com.itheima.entity.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result page(String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){
//        if(page==null)page=1;
//        if(pageSize==null)pageSize=10;
        log.info("分页查询：{},{},{},{},{},{}",name,gender,begin,end,page,pageSize);
        //PageBean pageBean = empService.page(page,pageSize);
        PageBean pageBean = empService.pageHelper(name,gender,begin,end,page,pageSize);//使用pagehelper分页插件
        return Result.success(pageBean);
    }

    @MyLog
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除：{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    @MyLog
    @PostMapping("/emps")
    public Result add(@RequestBody Emp emp){
        log.info("新增：{}",emp);
        empService.add(emp);
        return Result.success();
    }

    @GetMapping("/emps/{id}")
    public Result getById(@PathVariable Integer id){
        Emp emp=empService.getById(id);
        log.info("回显：id={},{}",id,emp);
        return Result.success(emp);
    }

    @MyLog
    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp){
        log.info("更新信息：{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
