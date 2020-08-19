/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyCallable
 * Author:   gyr
 * Date:     2020/6/25 15:15
 * Description:
 */
package com.example.demo.Ajava.for线程.for线程池返回值;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("=====任务执行了MyCallable====");
        return "ok";
    }
}