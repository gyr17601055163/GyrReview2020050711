/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: WeiXingRunnable
 * Author:   gyr
 * Date:     2020/6/25 16:17
 * Description:
 */
package com.example.demo.Ajava.for线程.for线程池.for卫星案例;

import java.util.concurrent.ScheduledExecutorService;

public class WeiXingRunnable implements Runnable {

    private ScheduledExecutorService scheduledExecutorService;
    private int timeCount = 1;

    public WeiXingRunnable(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

    @Override
    public void run() {

        if (timeCount > 3){
            scheduledExecutorService.shutdown();
        }else{
            System.out.println("---发生http请求，连接卫星---连接次数：第"+timeCount);
            timeCount++;
        }

    }
}