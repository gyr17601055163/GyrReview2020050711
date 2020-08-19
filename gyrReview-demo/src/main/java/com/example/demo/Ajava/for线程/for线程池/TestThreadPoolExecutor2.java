/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestThreadPoolExecutor2
 * Author:   gyr
 * Date:     2020/6/24 22:59
 * Description: 阻塞队列ArrayBlockingQueue的使用
 */
package com.example.demo.Ajava.for线程.for线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor2 {

    public static void main(String[] args) {

        /**
         * LinkedBlockingQueue和ArrayBlockingQueue区别
         * LinkedBlockingQueue队列的长度理论上是无限长
         * ArrayBlockingQueue需要设置队列的长度
         */
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(2);

        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                2,60, TimeUnit.SECONDS,arrayBlockingQueue,
                new MyRejectedImpl(linkedBlockingQueue));

        /**
         * 在运行第5个任务的时候会报RejectedExecutionException拒绝入队的异常，解决的办法是在创建线程池
         * 的时候加上它的第六个参数
         */
        for (int i = 0; i < 5; i++){
            threadPoolExecutor.execute(new MyRunnableExe());
        }

    }

}