/**
 * Copyright (C),2018-2020, XXX有限公司
 * FileName: Subject
 * Author:   gyr
 * Date:     2020/8/19 12:23
 * Description:
 * History:
 */
package com.example.demo.Ajava.for设计模式.for观察者模式.气象台案例;

/**
 * 观察者
 */
public interface Watcher {

    /**
     * 被观察者发生变化的时候，通知观察者发生变化，观察者修改
     */
    public void update();
}