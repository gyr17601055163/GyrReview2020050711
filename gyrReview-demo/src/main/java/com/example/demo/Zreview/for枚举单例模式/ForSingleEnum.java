package com.example.demo.Zreview.for枚举单例模式;

public enum ForSingleEnum {
    SINGLE;

    private ForSingleObject forSingleObject;

    private ForSingleEnum(){
        forSingleObject = new ForSingleObject();
    }

    public ForSingleObject getSingleObject(){
        System.out.println("枚举单例");
        return forSingleObject;
    }
}
