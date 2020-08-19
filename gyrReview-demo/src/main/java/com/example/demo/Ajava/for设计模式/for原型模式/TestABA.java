/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestABA
 * Author:   gyr
 * Date:     2020/8/6 19:47
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for原型模式;

import lombok.Data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 如果想克隆某个类，该类需要实现Cloneable接口
 * 如果想深克隆某个类，该类还需要实现Serializable接口
 */
@Data
public class TestABA implements Cloneable, Serializable {

    //基本数据类型
    private int age;

    //引用数据类型
    private String userName;
    private List<Map<String,Object>> userList;

    /**
     * 浅克隆（调用父类的clone方法来完成）
     */
    public TestABA getClone() throws CloneNotSupportedException {
        return (TestABA)super.clone();
    }

    /**
     * 深克隆（通过序列化和反序列化来完成）
     */
    public TestABA getDeepClone() throws IOException, ClassNotFoundException {

        //先输出对象
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //需要一个对象输出流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        //写出当前对象（写出到byteArrayOutputStream中）
        objectOutputStream.writeObject(this);

        //byteArrayOutputStream.toByteArray()获取输入的对象
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        TestABA testABA = (TestABA)objectInputStream.readObject();

        //关流
        objectInputStream.close();
        byteArrayInputStream.close();
        objectOutputStream.close();
        byteArrayOutputStream.close();

        return testABA;
    }

}