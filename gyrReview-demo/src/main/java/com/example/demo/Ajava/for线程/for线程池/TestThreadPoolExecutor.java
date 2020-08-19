/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestThreadPoolExecutor
 * Author:   gyr
 * Date:     2020/6/24 22:15
 * Description:
 */
package com.example.demo.Ajava.for线程.for线程池;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor {

    public static void main(String[] args) {

        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                    4,  //核心线程数
                    4,  //最大线程数
                    60, //线程存活时间
                    TimeUnit.SECONDS,   //存活时间单位
                    linkedBlockingQueue);   //工作队列

        //执行任务
        threadPoolExecutor.execute(new MyRunnableExe());

        //是否允许核心线程数超时
        //threadPoolExecutor.allowsCoreThreadTimeOut();

        //从线程池中移除任务
        //threadPoolExecutor.remove(new MyRunnableExe());

        //获取线程池中存活的线程个数
        //threadPoolExecutor.getActiveCount();

        //获取线程池核心线程数的个数
        //threadPoolExecutor.getCorePoolSize();

        //获取线程存活时间
        //threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS);

        //关闭线程池
        threadPoolExecutor.shutdown();

    }

}