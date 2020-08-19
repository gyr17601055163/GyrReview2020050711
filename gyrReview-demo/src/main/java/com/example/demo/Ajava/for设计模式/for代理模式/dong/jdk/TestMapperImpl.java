/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestMapperImpl
 * Author:   gyr
 * Date:     2020/7/22 10:47
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for代理模式.dong.jdk;

import java.util.List;
import java.util.Map;

public class TestMapperImpl implements TestMapper {

    @Override
    public List<Map<String, Object>> queryUserList(String str) {

        System.out.println("------------业务方法执行-------------"+str);

        return null;
    }
}