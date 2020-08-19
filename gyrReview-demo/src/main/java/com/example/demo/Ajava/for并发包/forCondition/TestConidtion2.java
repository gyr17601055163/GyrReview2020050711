/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestConidtion2
 * Author:   gyr
 * Date:     2020/6/27 9:05
 * Description:
 */
package com.example.demo.Ajava.for并发包.forCondition;

public class TestConidtion2 {
    public static void main(String[] args) throws InterruptedException {

        MyConditonUtils myConditonUtils = new MyConditonUtils();

        Thread thread1 = new Thread(new ConditionARunnable(myConditonUtils));
        thread1.start();

        Thread thread2 = new Thread(new ConditionBRunnable(myConditonUtils));
        thread2.start();

        Thread.sleep(2000);

        myConditonUtils.signalA();
        myConditonUtils.signalB();


    }
}