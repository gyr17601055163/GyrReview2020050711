/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: SingleTest
 * Author:   gyr
 * Date:     2020/6/19 20:08
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for单例模式;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 枚举单例测试使用类(通过多线程来测试枚举单例的安全性：即多线程中，对象始终为一个)
 */
public class SingleTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CountDownLatch countDownLatch = new CountDownLatch(4);

        //用于获取线程执行完成之后的运行结果，FutureTask的get()方法是用来获取结果的方法
        FutureTask f1 = new FutureTask(new MyCallable(countDownLatch));
        Thread t1 = new Thread(f1);
        t1.start();

        FutureTask f2 = new FutureTask(new MyCallable(countDownLatch));
        Thread t2 = new Thread(f2);
        t2.start();

        FutureTask f3 = new FutureTask(new MyCallable(countDownLatch));
        Thread t3 = new Thread(f3);
        t3.start();

        FutureTask f4 = new FutureTask(new MyCallable(countDownLatch));
        Thread t4 = new Thread(f4);
        t4.start();

        countDownLatch.await();     //等待上面的四个任务都执行完成后，主线程才能继续执行
        Object result1 = f1.get();  //获取线程执行结果
        Object result2 = f2.get();
        Object result3 = f3.get();
        Object result4 = f4.get();

        System.out.println(result1==result2);
        System.out.println(result1==result3);
        System.out.println(result1==result4);
    }
}