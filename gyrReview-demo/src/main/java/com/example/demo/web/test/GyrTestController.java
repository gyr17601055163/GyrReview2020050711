/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: GyrTestController
 * Author:   gyr
 * Date:     2020/6/19 18:02
 * Description:
 */
package com.example.demo.web.test;

import com.example.demo.service.test.GyrTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GyrTestController {

    @Autowired
    private GyrTestService gyrTestService;

    @RequestMapping("/test")
    public String test(){
        List<Map<String, Object>> testList = gyrTestService.queryTest();
        for (Map<String,Object> testMap:testList){
            System.out.println("---->gyr:"+testMap.toString());
        }

        return "123";
    }
}