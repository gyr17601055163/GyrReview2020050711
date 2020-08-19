/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestThreadPoolExecutor2
 * Author:   gyr
 * Date:     2020/6/25 15:21
 * Description:
 */
package com.example.demo.Ajava.for线程.for线程池返回值;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,4,60, TimeUnit.SECONDS,
                arrayBlockingQueue);

        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());

        threadPoolExecutor.execute(futureTask);

        String s = futureTask.get();

        System.out.println("s"+s);

        threadPoolExecutor.shutdown();

    }
}