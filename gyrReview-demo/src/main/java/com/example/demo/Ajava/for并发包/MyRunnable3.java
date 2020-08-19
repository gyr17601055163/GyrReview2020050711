/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyRunnable3
 * Author:   gyr
 * Date:     2020/6/25 19:06
 * Description:
 */
package com.example.demo.Ajava.for并发包;

import java.util.concurrent.Semaphore;

public class MyRunnable3 implements Runnable {

    private String name;
    private int time;
    private Semaphore semaphore;

    public MyRunnable3(String name, int time, Semaphore semaphore) {
        this.name = name;
        this.time = time;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            //获取一个许可，如果没有获取到，则阻塞到这个位置
            semaphore.acquire();

            Thread.sleep(time);

            System.out.println(name+"：工作完成，归还工具");

            //释放一个许可
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}