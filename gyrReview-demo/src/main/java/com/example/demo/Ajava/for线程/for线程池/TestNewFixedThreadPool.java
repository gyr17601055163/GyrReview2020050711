/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestNewFixedThreadPool
 * Author:   gyr
 * Date:     2020/6/25 15:02
 * Description: newFixedThreadPool 创建固定大小的线程池
 */
package com.example.demo.Ajava.for线程.for线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNewFixedThreadPool {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        //执行
        for (int i = 0; i < 3; i++)
         executorService.submit(new MyRunnableExe());

        //关闭线程
        executorService.shutdown();

    }
}