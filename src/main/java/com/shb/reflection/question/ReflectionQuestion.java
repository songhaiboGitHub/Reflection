package com.shb.reflection.question;

import com.shb.Cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 反射问题引入
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException {
        //根据配置文件re.properties指定信息，创建Cat对象并调用方法hi


        //传统方式 new 对象  -》调用其方法
        Cat cat = new Cat();
        cat.hi();

        //文件流 Properties
        Properties properties = new Properties();
        properties.load(new FileInputStream("src//re.properties"));
    }
}
