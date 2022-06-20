package com.shb.reflection.class_;

import java.io.Serializable;

/**
 * 哪些类型有Class对象
 */
public class AllTypeClass {
    public static void main(String[] args) {
//        1. 外部类，成员内部类，静态内部类，局部内部类，匿名内部类
        Class<String> cls1 = String.class;//外部类
        System.out.println(cls1);
//        2. interface接口
        Class<Serializable> cls2 = Serializable.class; //接口
        System.out.println(cls2);
//        3. 数组
        Class<Integer[]> cls3 = Integer[].class;//数组
        System.out.println(cls3);
//        4. enum枚举
        Class<Thread.State> cls4 = Thread.State.class;//枚举
        System.out.println(cls4);
//        5. annotation注解
        Class<Deprecated> cls5 = Deprecated.class;//注解
        System.out.println(cls5);
//        6. 基本数据类型
        Class<Integer> cls6 = int.class;//基本数据类型
        System.out.println(cls6);
//        7. void
        Class<Void> cls7 = void.class;//void
        System.out.println(cls7);
    }

}
