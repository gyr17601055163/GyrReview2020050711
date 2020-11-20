package com.example.demo.mapper.user;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {
    @Override
    public List<Map<String, Object>> getUserList(Map<String, Object> map) {
        System.out.println("=========查寻用户列表");
        return null;
    }

    @Override
    public boolean saveUserMassage(Map<String, Object> map) {
        System.out.println("=========添加用户信息");
        return false;
    }

    @Override
    public boolean delUserMassage(String userId) {
        System.out.println("=========删除用户信息");
        return false;
    }

    @Override
    public boolean updateUserName(Map<String, Object> map) {
        System.out.println("=========修改用户信息");
        return false;
    }
}
