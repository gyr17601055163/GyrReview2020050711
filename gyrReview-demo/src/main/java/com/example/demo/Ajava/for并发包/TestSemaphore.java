/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestSemaphore
 * Author:   gyr
 * Date:     2020/6/25 19:05
 * Description: Semaphore作用：可以控制同时访问线程的个数
 */
package com.example.demo.Ajava.for并发包;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new MyRunnable3("A",2000,semaphore));
        executorService.submit(new MyRunnable3("B",2000,semaphore));
        executorService.submit(new MyRunnable3("C",4000,semaphore));
        executorService.submit(new MyRunnable3("D",4000,semaphore));

        executorService.shutdown();

    }
}