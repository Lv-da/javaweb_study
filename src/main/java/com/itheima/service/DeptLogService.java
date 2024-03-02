package com.itheima.service;

import com.itheima.entity.DeptLog;
import org.springframework.transaction.annotation.Transactional;

public interface DeptLogService {
    @Transactional
    void insert(DeptLog deptLog);
}
