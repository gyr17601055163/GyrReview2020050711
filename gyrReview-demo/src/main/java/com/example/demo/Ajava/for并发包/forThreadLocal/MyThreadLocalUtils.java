/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyThreadLocalUtils
 * Author:   gyr
 * Date:     2020/6/27 21:14
 * Description:
 */
package com.example.demo.Ajava.for并发包.forThreadLocal;

public class MyThreadLocalUtils {

    private ThreadLocal<Teacher> threadLocal = new ThreadLocal<>();

    public Teacher getTeacher(){

        if (threadLocal.get() != null){
            return threadLocal.get();
        }else {
            Teacher teacher = new Teacher("张三");
            threadLocal.set(teacher);
            return threadLocal.get();
        }
    }

}