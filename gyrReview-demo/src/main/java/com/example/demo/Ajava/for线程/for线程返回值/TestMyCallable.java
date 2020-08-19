/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestMyCallable
 * Author:   gyr
 * Date:     2020/6/25 14:35
 * Description:
 */
package com.example.demo.Ajava.for线程.for线程返回值;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestMyCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CountDownLatch countDownLatch = new CountDownLatch(4);

        FutureTask<String> futureTask1 = new FutureTask<>(new MyCallable(countDownLatch));
        Thread thread1 = new Thread(futureTask1,"A");
        thread1.start();

        FutureTask<String> futureTask2 = new FutureTask<>(new MyCallable(countDownLatch));
        Thread thread2 = new Thread(futureTask2,"B");
        thread2.start();

        thread1.join();
        thread2.join();

        String result1 = futureTask1.get();
        String result2 = futureTask1.get();

        System.out.println("- - - - > result1 = "+result1+", result2 = "+result2);

    }

}