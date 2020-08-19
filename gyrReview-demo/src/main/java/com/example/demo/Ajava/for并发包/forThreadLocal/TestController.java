/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestController
 * Author:   gyr
 * Date:     2020/6/27 21:22
 * Description:
 */
package com.example.demo.Ajava.for并发包.forThreadLocal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private MyThreadLocalUtils myThreadLocalUtils = new MyThreadLocalUtils();

    @RequestMapping("test001")
    public void test001(){
        Teacher teacher = myThreadLocalUtils.getTeacher();
        System.out.println(teacher.getName()+"----1");
        teacher.setName("李四");
        Teacher teacher2 = myThreadLocalUtils.getTeacher();
        System.out.println(teacher2.getName()+"----2");
    }

    @RequestMapping("test002")
    public void test002(){
        Teacher teacher = myThreadLocalUtils.getTeacher();
        System.out.println(teacher.getName()+"----1");
    }
}