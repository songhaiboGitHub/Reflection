package com.shb.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射访问类中的成员
 * ● 访问方法
 */
public class ReflectAccessMethod {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        //1、得到Boss类对应的对象
        Class<?> cls = Class.forName("com.shb.reflection.Boss");
        //2、创建对象
        Object o = cls.newInstance();
        //3、调用public hi方法
        Method hi = cls.getMethod("hi", String.class);
        hi.invoke(o, "晓丽");
        //4、调用private static方法say()
        Method say = cls.getDeclaredMethod("say", int.class, String.class, char.class);
        //应为say方法是私有的所以需要爆破
        say.setAccessible(true);
        Object invoke = say.invoke(o, 100, "张三", '男');
        //运行类型就是返回值类型 String
        System.out.println(invoke);
        //因为say方法是static可以传null调用
        say.invoke(null, 100, "张三", '男');

    }
}


class Boss {
    private static String name;
    public int age;

    public Boss() {

    }

    private static String say(int n, String s, char c) {
        System.out.println(n + " " + s + " " + c);
        return n + " " + s + " " + c + " 我是return";
    }

    public void hi(String s) {
        System.out.println("hi~ " + s);
    }

    @Override
    public String toString() {
        return "Boss{" +
                "age=" + age +
                '}';
    }
}