/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestWeiXing
 * Author:   gyr
 * Date:     2020/6/25 16:18
 * Description:
 */
package com.example.demo.Ajava.for线程.for线程池.for卫星案例;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestWeiXing {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        /**
         * 按指定频率周期执行某个任务，初始化延迟0s开始执行，每隔3s执行一次任务
         * 参数1：执行线程
         * 参数2：初始化延时
         * 参数3：两次开始执行最小间隔时间
         * 参数4：计时单位
         */
        scheduledExecutorService.scheduleAtFixedRate(
                new WeiXingRunnable(scheduledExecutorService),
                0,
                3,
                TimeUnit.SECONDS);

    }
}