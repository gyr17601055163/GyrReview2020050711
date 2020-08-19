/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestCountdownLatch
 * Author:   gyr
 * Date:     2020/6/28 21:14
 * Description:
 */
package com.example.demo.Zreview.for并发包;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestCountdownLatch {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(4);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,6,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>());

        threadPoolExecutor.execute(new MyThread2(countDownLatch,1000));
        threadPoolExecutor.execute(new MyThread2(countDownLatch,4000));
        threadPoolExecutor.execute(new MyThread2(countDownLatch,3000));
        threadPoolExecutor.execute(new MyThread2(countDownLatch,5000));

        countDownLatch.await();

        System.out.println("------裁判员：预备！！开跑-------");

        threadPoolExecutor.shutdown();

    }
}