/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: WatcherData
 * Author:   gyr
 * Date:     2020/8/19 12:34
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for观察者模式.气象台案例;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 追踪来自气象站的数据，并更新公告牌
 */
@Data
public class WatcherData implements ObWatcher{


    private List<Watcher> watchers;

    private float wendu;//温度
    private float shidu;//湿度
    private float qiya;//气压


    private List<Float> weiLaiTianQi;//未来几天的温度


    public WatcherData(){
        watchers = new ArrayList<>();
    }


    @Override
    public void registerWatcher(Watcher watcher) {
        watchers.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        watchers.remove(watcher);
    }

    @Override
    public void notifyWatcher() {
        watchers.forEach(wa->{
            wa.update();
        });
    }

    /**
     * 数据发生改变的时候，通知观察者（调用通知方法）
     */
    public void dataChanged(){
        notifyWatcher();
    }

    /**
     * 追踪来自气象站的数据
     * @param wendu
     * @param shidu
     * @param qiya
     * @param weiLaiTianQi
     */
    public void setData(float wendu,float shidu,float qiya,List<Float> weiLaiTianQi){
        this.wendu = wendu;
        this.shidu = shidu;
        this.qiya = qiya;
        this.weiLaiTianQi = weiLaiTianQi;
        dataChanged();
    }
}