/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: ConditionAThread
 * Author:   gyr
 * Date:     2020/6/26 12:56
 * Description:
 */
package com.example.demo.Ajava.for并发包.forCondition;

public class ConditionAThread /*implements Runnable*/ extends Thread{

    private MyConditonUtils myConditonUtils;

    public ConditionAThread(MyConditonUtils myConditonUtils) {
        this.myConditonUtils = myConditonUtils;
    }

    @Override
    public void run() {
        myConditonUtils.waitA();
        System.out.println("------A---获得通知 继续运行--------");
    }
}