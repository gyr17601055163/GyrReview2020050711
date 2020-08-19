/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestCondition
 * Author:   gyr
 * Date:     2020/6/26 13:00
 * Description:
 */
package com.example.demo.Ajava.for并发包.forCondition;

public class TestCondition {
    public static void main(String[] args) throws InterruptedException {

        MyConditonUtils myConditonUtils = new MyConditonUtils();

        ConditionAThread threadA = new ConditionAThread(myConditonUtils);
        threadA.start();

        ConditionBThread threadB = new ConditionBThread(myConditonUtils);
        threadB.start();

        Thread.sleep(2000);

        myConditonUtils.signalA();
        myConditonUtils.signalB();

    }
}