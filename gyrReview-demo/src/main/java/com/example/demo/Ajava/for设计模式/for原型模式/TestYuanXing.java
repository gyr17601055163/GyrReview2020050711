/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestYuanXing
 * Author:   gyr
 * Date:     2020/8/6 20:21
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for原型模式;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestYuanXing {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        List<Map<String,Object>> list = new ArrayList<>();

        Map<String,Object> map = new HashMap<>();
        map.put("AAA","aaa");
        map.put("BBB","bbb");

        list.add(map);

        TestABA testABA = new TestABA();
        testABA.setAge(10);
        testABA.setUserName("zhangsan");
        testABA.setUserList(list);

        //通过原型模式创建对象（浅克隆）
        TestABA clone = testABA.getClone();
        System.out.println(testABA.getAge() == clone.getAge()); //true
        System.out.println(testABA.getUserName() == clone.getUserName()); //true
        System.out.println(testABA.getUserList() == clone.getUserList()); //true

        //通过原型模式创建对象（深克隆）
        TestABA deepClone = testABA.getDeepClone();
        System.out.println(testABA.getAge() == deepClone.getAge()); //true
        System.out.println(testABA.getUserName() == deepClone.getUserName()); //false
        System.out.println(testABA.getUserList() == deepClone.getUserList()); //false

        /**
         * 深克隆和浅克隆的区别：
         *      深克隆：克隆对象会重新创建所有的引用类型，基本类型保持不变
         *      浅克隆：克隆对象中属性的引用会直接拿原来对象的引用
         */

    }
}