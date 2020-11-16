package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data                       //JDK的序列化方式：实现Serializable接口
public class TestUser implements Serializable {
    public String userName;
    public String passWord;
}
