package com.example.demo.mapper.databaseLocking;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestLock {

    @Select("select * from user where id>=#{id} for update")
    public List<Map<String,Object>> getList(String id);

    @Select("select * from user where id=#{id} for update")
    public List<Map<String,Object>> getList2(String id);

}
