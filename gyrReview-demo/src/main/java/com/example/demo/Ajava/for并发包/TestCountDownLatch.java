/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestCountDownLatch
 * Author:   gyr
 * Date:     2020/6/25 18:15
 * Description:
 */
package com.example.demo.Ajava.for并发包;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(4);

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,6,60, TimeUnit.SECONDS,arrayBlockingQueue);

        for (int i = 0; i < 4; i++){
            threadPoolExecutor.execute(new MyRunnable1(countDownLatch));
        }

        countDownLatch.await();

        System.out.println("老师说：好，我们继续下面的内容");

        threadPoolExecutor.shutdown();

    }
}