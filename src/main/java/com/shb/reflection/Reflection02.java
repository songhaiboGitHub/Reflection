package com.shb.reflection;

import com.shb.Cat;

import java.lang.reflect.Method;

public class Reflection02 {

    public static void main(String[] args) throws Exception {
        //Field  setAccessible
        //Method  setAccessible
        //Constructor  setAccessible
        m1();
        m2();
        m3();
    }

    //普通方法调用hi
    public static void m1() {

        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("普通方法调用hi 耗时 " + (end - start));

    }

    //反射机制调用hi
    public static void m2() throws Exception {
        //(1)加载class类 返回Class对象
        Class<?> cls = Class.forName("com.shb.Cat");
        Object o = cls.newInstance();
        long start = System.currentTimeMillis();
        Method method = cls.getMethod("hi");
        for (int i = 0; i < 900000000; i++) {
            method.invoke(o);//传统方式 对象.方法   反射机制 方法.invoke(对象)
        }
        long end = System.currentTimeMillis();
        System.out.println("反射机制调用hi 耗时 " + (end - start));

    }

    //反射调用优化  关闭安全检测  setAccessible
    public static void m3() throws Exception {
        //(1)加载class类 返回Class对象
        Class<?> cls = Class.forName("com.shb.Cat");
        Object o = cls.newInstance();
        long start = System.currentTimeMillis();
        Method method = cls.getMethod("hi");
        method.setAccessible(true); //在反射调用方法时取消安全检测，提高运行效率
        for (int i = 0; i < 900000000; i++) {
            method.invoke(o);//传统方式 对象.方法   反射机制 方法.invoke(对象)
        }
        long end = System.currentTimeMillis();
        System.out.println("反射调用优化  关闭安全检测 调用hi 耗时 " + (end - start));

    }

}
