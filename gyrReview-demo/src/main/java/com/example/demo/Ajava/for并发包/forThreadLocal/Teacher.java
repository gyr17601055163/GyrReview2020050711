/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: Teacher
 * Author:   gyr
 * Date:     2020/6/27 21:15
 * Description: 被操作类
 */
package com.example.demo.Ajava.for并发包.forThreadLocal;

public class Teacher {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}