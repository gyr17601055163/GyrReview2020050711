/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyRejectedImpl
 * Author:   gyr
 * Date:     2020/6/24 23:26
 * Description:
 */
package com.example.demo.Ajava.for线程.for线程池;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejectedImpl implements RejectedExecutionHandler {

    private LinkedBlockingQueue<Runnable> linkedBlockingQueue;

    public MyRejectedImpl(LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        this.linkedBlockingQueue = linkedBlockingQueue;
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        /*try {
            linkedBlockingQueue.put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        executor.execute(r);
    }
}