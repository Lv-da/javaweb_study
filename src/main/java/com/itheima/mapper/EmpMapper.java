package com.itheima.mapper;

import com.itheima.entity.Emp;
import com.itheima.entity.Login;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select count(id) from emp")
    public Long count();

    @Select("select * from emp limit #{start},#{pagesize}")
    public List<Emp> page(Integer start,Integer pagesize);

    @Select("select * from emp")
    public List<Emp> all();

    public List<Emp> getAll(String name, Short gender, LocalDate begin, LocalDate end);

    public void delete(List<Integer> ids);

    public void add(Emp emp);

    @Select("select * from emp where id=#{id}")
    public Emp getById(Integer id);

    public void update(Emp emp);

    @Select("select * from emp where username=#{username} and password=#{password}")
    public Emp login(Login login);

    @Delete("delete from emp where dept_id=#{deptId}")
    void deleteByDeptId(Integer deptId);
}
