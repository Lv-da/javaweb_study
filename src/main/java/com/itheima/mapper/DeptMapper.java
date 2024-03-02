package com.itheima.mapper;

import com.itheima.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("SELECT * from dept")
    public List<Dept> list();

    @Delete("DELETE from dept where id=#{id}")
    public void deleteById(Integer id);

    @Insert("insert into dept(name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")
    public void insert(Dept dept);

    @Select("select * from dept where id=#{id}")
    public Dept getById(Integer id);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    public void update(Dept dept);
}
