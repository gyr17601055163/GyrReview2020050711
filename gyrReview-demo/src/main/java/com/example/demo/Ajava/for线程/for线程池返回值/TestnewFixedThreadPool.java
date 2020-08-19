/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestnewFixedThreadPool
 * Author:   gyr
 * Date:     2020/6/25 15:17
 * Description:
 */
package com.example.demo.Ajava.for线程.for线程池返回值;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestnewFixedThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());

        //执行
        executorService.submit(futureTask);

        //获取返回值
        String result = futureTask.get();
        System.out.println("result");

        executorService.shutdown();

    }

}