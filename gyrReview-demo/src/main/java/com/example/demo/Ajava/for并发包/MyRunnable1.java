/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyRunnable1
 * Author:   gyr
 * Date:     2020/6/25 18:17
 * Description:
 */
package com.example.demo.Ajava.for并发包;

import java.util.concurrent.CountDownLatch;

public class MyRunnable1 implements Runnable {

    private CountDownLatch countDownLatch;

    public MyRunnable1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread()+"同学说：听懂了");
        countDownLatch.countDown();
    }
}