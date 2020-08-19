package com.example.demo.Ajava.for设计模式.for单例模式.for枚举单例;

public enum MeiJuDanLi {

    INSTANCE;

    private MeiJuDanLi(){

    }

    public MeiJuDanLi getInstance(){
        return MeiJuDanLi.INSTANCE;
    }

}
