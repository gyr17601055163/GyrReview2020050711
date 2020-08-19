/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyRunnable2
 * Author:   gyr
 * Date:     2020/6/25 18:40
 * Description:
 */
package com.example.demo.Ajava.for并发包;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyRunnable2 implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private int time;

    public MyRunnable2(CyclicBarrier cyclicBarrier, int time) {
        this.cyclicBarrier = cyclicBarrier;
        this.time = time;
    }

    @Override
    public void run() {
        try {

            Thread.sleep(time);

            System.out.println("运动员"+Thread.currentThread().getName()+"：准备就绪");

            cyclicBarrier.await(); //线程阻塞在这里，并进行减一操作，直到所有的线程全部运行完，执行下面的代码

            System.out.println("裁判员：预备！！开跑");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}