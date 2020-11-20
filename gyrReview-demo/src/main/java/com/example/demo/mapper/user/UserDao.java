package com.example.demo.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public interface UserDao {

    /**
     * 获取用户列表
     * @param map
     * @return
     */
    public List<Map<String,Object>> getUserList(Map<String,Object> map);

    /**
     * 添加用户信息
     * @param map
     * @return
     */
    public boolean saveUserMassage(Map<String,Object> map);

    /**
     * 查寻用户信息
     * @param userId
     * @return
     */
    public boolean delUserMassage(String userId);

    /**
     * 修改用户名字
     * @param map
     * @return
     */
    public boolean updateUserName(Map<String,Object> map);
}
