/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: SingleEnumTest
 * Author:   gyr
 * Date:     2020/6/19 21:54
 * Description:
 */
package com.example.demo.Zreview.for枚举单例模式;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SingleEnumTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        FutureTask f1 = new FutureTask(new MySingleCallable(countDownLatch));
        Thread t1 = new Thread(f1);
        t1.start();

        FutureTask f2 = new FutureTask(new MySingleCallable(countDownLatch));
        Thread t2 = new Thread(f2);
        t2.start();

        FutureTask f3 = new FutureTask(new MySingleCallable(countDownLatch));
        Thread t3 = new Thread(f3);
        t3.start();

        countDownLatch.await();
        Object o1 = f1.get();
        Object o2 = f1.get();
        Object o3 = f1.get();

        System.out.println(o1 == o2);
        System.out.println(o1 == o3);
        System.out.println(o3 == o2);

    }
}