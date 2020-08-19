/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: GyrTestService
 * Author:   gyr
 * Date:     2020/6/19 18:10
 * Description:
 */
package com.example.demo.service.test;

import com.example.demo.mapper.test.GyrTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GyrTestService {

    @Autowired
    private GyrTestMapper gyrTestMapper;

    public List<Map<String,Object>> queryTest(){
        return gyrTestMapper.queryTest();
    }
}