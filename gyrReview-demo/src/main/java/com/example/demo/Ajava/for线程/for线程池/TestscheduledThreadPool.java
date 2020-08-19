/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestscheduledThreadPool
 * Author:   gyr
 * Date:     2020/6/25 15:48
 * Description: scheduledThreadPool创建带定时的线程池，可以调度的线程池
 */
package com.example.demo.Ajava.for线程.for线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestscheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        //按固定频率去调用
        scheduledExecutorService.scheduleAtFixedRate(new MyRunnableExe(),0,2, TimeUnit.SECONDS);


    }
}