package com.example.demo.web.databaseLocking;

import com.example.demo.service.databaseLocking.TestLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestLockController {

    @Autowired
    public TestLockService testLockService;

    //访问路径：localhost:8080/getList/1
    @RequestMapping("/getList/{id}")
    public List<Map<String,Object>> getList(@PathVariable("id") String id) throws InterruptedException {
        return testLockService.getList(id);
    }
    //访问路径：localhost:8080/getList?id=1
    @RequestMapping("/getList2")
    public List<Map<String,Object>> getList2(@RequestParam(value = "id") String id) throws InterruptedException {
        return testLockService.getList(id);
    }
}
