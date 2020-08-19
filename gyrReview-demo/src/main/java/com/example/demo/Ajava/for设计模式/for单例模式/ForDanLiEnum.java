package com.example.demo.Ajava.for设计模式.for单例模式;

/**
 * 枚举单例
 */
public enum ForDanLiEnum {
    SINGLE;

    private ForDanLiObject forDanLiObject;

    private ForDanLiEnum(){
        forDanLiObject = new ForDanLiObject();
    }

    public ForDanLiObject getSingle(){
        return forDanLiObject;
    }
}
