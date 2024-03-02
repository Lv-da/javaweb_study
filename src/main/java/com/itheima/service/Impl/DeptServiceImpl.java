package com.itheima.service.Impl;

import com.itheima.entity.Dept;
import com.itheima.entity.DeptLog;
import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.service.DeptLogService;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    public List<Dept> list(){
        return deptMapper.list();
    }

    //事务管理，将当前方法交给spring进行事务管理，方法执行前开启，成功执行完毕则提交事务，否则回滚事务
    //默认触发runtimeException才回滚，rollbackFor设置遇到何种异常时回滚
    //propagation控制事务传播行为，当一个事务方法被另一个事务方法调用时如何进行事务控制
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id){
        try {
            deptMapper.deleteById(id);
            //根据部门id删除部门下员工信息
            empMapper.deleteByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("delete No."+id+" dept");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void insert(Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
