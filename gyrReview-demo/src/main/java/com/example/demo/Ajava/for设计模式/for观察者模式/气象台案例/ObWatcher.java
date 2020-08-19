/**
 * Copyright (C),2018-2020, XXX有限公司
 * FileName: ObWatcher
 * Author:   gyr
 * Date:     2020/8/19 12:28
 * Description:
 * History:
 */
package com.example.demo.Ajava.for设计模式.for观察者模式.气象台案例;

/**
 * 被观察者
 */
public interface ObWatcher {


    /**
     * 注册观察者
     * @param watcher
     */
    public void registerWatcher(Watcher watcher);


    /**
     * 移除观察者
     * @param watcher
     */
    public void removeWatcher(Watcher watcher);


    /**
     * 通知观察者
     * @param watcher
     */
    public void notifyWatcher();
}