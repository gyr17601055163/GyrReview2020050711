package com.example.demo.service.databaseLocking;

import com.example.demo.mapper.databaseLocking.TestLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
public class TestLockService {

    @Autowired
    private TestLock testLock;

    @Transactional
    public List<Map<String,Object>> getList(String id) throws InterruptedException {
        List<Map<String, Object>> list = testLock.getList(id);
        Thread.sleep(30000);
        return list;
    }

    @Transactional
    public List<Map<String,Object>> getList2(String id) throws InterruptedException {
        return testLock.getList2(id);
    }

}
