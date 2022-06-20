package com.shb.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("/Users/ext.songhaibo/IdeaProjects/Reflection/src/main/resources/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();

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

        //java.lang.reflect.Field：代表类的成员变量
        //获取name字段
        //getField不能得到私有的属性
        Field nameField = cls.getField("age");
        System.out.println(nameField.get(o));//传统写法 对象.属性名   反射：成员变量.get(对象)

        //java.lang.reflect.Constructor：代表类的构造方法
        Constructor<?> constructor = cls.getConstructor();//()可以指定构造器参数类型，目前无参构造
        System.out.println(constructor);
        //有参构造获取
        Constructor<?> constructor2 = cls.getConstructor(String.class);//String.class就是String的对象
        System.out.println(constructor2);

    }
}
