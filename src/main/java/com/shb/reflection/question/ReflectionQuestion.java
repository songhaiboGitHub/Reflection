package com.shb.reflection.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射问题引入
 */
public class ReflectionQuestion {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //根据配置文件re.properties指定信息，创建Cat对象并调用方法hi

        //传统方式 new 对象  -》调用其方法
       /* Cat cat = new Cat();
        cat.hi();*/

        //文件流方式 Properties
        //1、取出配置文件值
        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/ext.songhaibo/IdeaProjects/Reflection/src/main/resources/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath = " + classfullpath);
        System.out.println("methodName = " + methodName);
        //2、创建对象 传统的方法已经不行了
        // new classfullpath();

        //反射模式符合开闭原则 OCP，外部文件配置  即在不修改源码的情况下，来控制程序

        //3、传统模式下解决不了就用反射机制
        //(1)加载class类 返回Class对象
        Class<?> cls = Class.forName(classfullpath);
        //(2)通过 cls 得到加载类  com.shb.Cat的对象实例
        Object o = cls.newInstance();
        System.out.println(o.getClass());
        //(3)通过 cls 得到加载的类的com.shb.Cat类的methodName"hi"的对象
        //即：在反射中，可以把方法视为对象（万物皆对象）
        Method method = cls.getMethod(methodName);
        //通过method来调用方法，即通过方法对象来调用方法
        method.invoke(o);//传统方式 对象.方法   反射机制 方法.invoke(对象)

    }
}
