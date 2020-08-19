/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyThread2
 * Author:   gyr
 * Date:     2020/6/28 21:14
 * Description:
 */
package com.example.demo.Zreview.for并发包;

import java.util.concurrent.CountDownLatch;

public class MyThread2 implements Runnable {

    private CountDownLatch countDownLatch;
    private int time;

    public MyThread2(CountDownLatch countDownLatch, int time) {
        this.countDownLatch = countDownLatch;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
            System.out.println(Thread.currentThread().getName()+"：准备就绪");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}