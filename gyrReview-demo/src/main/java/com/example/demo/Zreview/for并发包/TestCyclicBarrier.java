/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestCyclicBarrier
 * Author:   gyr
 * Date:     2020/6/28 21:03
 * Description:
 */
package com.example.demo.Zreview.for并发包;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestCyclicBarrier {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,6,60, TimeUnit.SECONDS,arrayBlockingQueue);

        threadPoolExecutor.execute(new MyThread(cyclicBarrier,"A",5000));
        threadPoolExecutor.execute(new MyThread(cyclicBarrier,"B",2000));
        threadPoolExecutor.execute(new MyThread(cyclicBarrier,"C",1000));
        threadPoolExecutor.execute(new MyThread(cyclicBarrier,"D",4000));

        System.out.println("------裁判员：预备！！开跑------");

        threadPoolExecutor.shutdown();

    }
}