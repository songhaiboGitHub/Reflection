package com.shb.reflection.class_;

import com.shb.Dog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 动态加载和静态加载
 */
public class ClassLoad_ {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入key");
        String next = scanner.next();
        switch (next) {
            case "1":
                //静态加载类 编译的时候加载报错编译不成功
                Dog dog = new Dog();
                dog.cry();
                break;
            case "2":
                System.out.println("ok");
                break;
            case "3":
                //编译通过，运行时加载  反射机制-》动态加载类
                Class<?> cls = Class.forName("com.shb.Dog");
                Object o = cls.newInstance();
                Method cry = cls.getMethod("cry");
                cry.invoke(o);
                break;
            default:
                System.out.println("default");
        }
    }
}
