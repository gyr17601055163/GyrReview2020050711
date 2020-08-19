/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestMeiJuDanLi
 * Author:   gyr
 * Date:     2020/8/7 11:59
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for单例模式.for枚举单例;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestMeiJuDanLi {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {

        MeiJuDanLi instance = MeiJuDanLi.INSTANCE.getInstance();

        /**
         * 通过反射暴力访问枚举单例start
         */
        /*Constructor<MeiJuDanLi> declaredConstructor = MeiJuDanLi.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        MeiJuDanLi meiJuDanLi = declaredConstructor.newInstance();

        System.out.println(meiJuDanLi == instance);//直接抛出NoSuchMethodException异常
*/

        /**
         * 通过序列化和反序列化的方式暴力访问枚举单例start
         */
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(instance);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        MeiJuDanLi instance2 = (MeiJuDanLi) objectInputStream.readObject();

        System.out.println(instance2 == instance); //true 同一个实例

    }
}