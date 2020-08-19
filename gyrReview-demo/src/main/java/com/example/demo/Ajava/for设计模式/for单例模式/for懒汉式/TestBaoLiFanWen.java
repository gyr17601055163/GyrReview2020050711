/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestBaoLiFanWen
 * Author:   gyr
 * Date:     2020/8/7 11:47
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for单例模式.for懒汉式;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestBaoLiFanWen {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {

        LanHan instance = LanHan.getInstance();

        /**
         * 通过反射的方式进行暴力访问
         */
        Constructor<LanHan> declaredConstructor = LanHan.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LanHan lanHan = declaredConstructor.newInstance();

        System.out.println(instance == lanHan); //不是同一个实例


        /**
         * 通过序列化和反序列化的方式进行暴力访问
         */
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(instance);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        LanHan instance2 = (LanHan) objectInputStream.readObject();

        objectInputStream.close();
        byteArrayInputStream.close();
        objectOutputStream.close();
        byteArrayOutputStream.close();

        System.out.println(instance == instance2); //不是同一个实例

    }
}