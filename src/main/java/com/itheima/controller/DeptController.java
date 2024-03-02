package com.itheima.controller;

import com.itheima.anno.MyLog;
import com.itheima.entity.Dept;
import com.itheima.entity.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")//公共请求路径,完整请求路径=类上@RequestMapping属性+方法上的@RequestMapper属性
public class DeptController {
    //private static Logger log= LoggerFactory.getLogger((DeptController.class));
    //用@Slf4j注解替代

    @Autowired
    private DeptService deptService;

    @GetMapping("")
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @MyLog
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门：{}",id);
        deptService.deleteById(id);
        return Result.success();
    }

    @MyLog
    @PostMapping("")
    public Result add(@RequestBody Dept dept){
        log.info("新增部门:{}",dept);
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询部门：{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @MyLog
    @PutMapping("")
    public Result update(@RequestBody Dept dept){
        log.info("根据id修改部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
