/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestDanli
 * Author:   gyr
 * Date:     2020/8/7 10:29
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for单例模式.for饿汉式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestDanli {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        DanLi danli = DanLi.getDanLi();

        /**
         * 饿汉式在多线程情况下是线程安全的（测试）start
         */
        FutureTask<DanLi> futureTask1 = new FutureTask<>(new Callable<DanLi>() {
            @Override
            public DanLi call() throws Exception {
                return danli;
            }
        });

        Thread thread1 = new Thread(futureTask1);

        FutureTask<DanLi> futureTask2 = new FutureTask<>(new Callable<DanLi>() {
            @Override
            public DanLi call() throws Exception {
                return danli;
            }
        });

        Thread thread2 = new Thread(futureTask2);

        FutureTask<DanLi> futureTask3 = new FutureTask<>(new Callable<DanLi>() {
            @Override
            public DanLi call() throws Exception {
                return danli;
            }
        });

        Thread thread3 = new Thread(futureTask3);

        thread1.start();
        thread2.start();
        thread3.start();

        DanLi danLi1 = futureTask1.get();
        DanLi danLi2 = futureTask2.get();
        DanLi danLi3 = futureTask3.get();

        System.out.println(danLi1 == danLi2);
        System.out.println(danLi1 == danLi3);
        System.out.println(danLi2 == danLi3);

    }
}