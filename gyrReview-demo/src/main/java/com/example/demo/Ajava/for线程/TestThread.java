/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestThread
 * Author:   gyr
 * Date:     2020/6/23 9:14
 * Description:
 */
package com.example.demo.Ajava.for线程;

import java.util.ArrayList;
import java.util.List;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<Integer>();

        MyTHreadObject myTHreadObject = new MyTHreadObject(list);
        Thread threadA = new Thread(myTHreadObject,"A");
        threadA.start();

        Thread threadB = new Thread(myTHreadObject,"B");
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("---->"+list.size());

    }
}