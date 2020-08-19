/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyThread
 * Author:   gyr
 * Date:     2020/6/28 21:04
 * Description:
 */
package com.example.demo.Zreview.for并发包;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String name;
    private int time;

    public MyThread(CyclicBarrier cyclicBarrier, String name, int time) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
            System.out.println("运动员"+name+"：准备就绪");
            cyclicBarrier.await();
            System.out.println("裁判员：预备！！开跑");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}