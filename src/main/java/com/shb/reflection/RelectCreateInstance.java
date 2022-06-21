package com.shb.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ● 通过反射创建对象
 * 1. 方式一：调用类中的public修饰的无参构造器
 * 2. 方式二：调用类中的指定构造器
 * 3. CLass类相关方法
 * a. newInstance：调用类中的无参构造器，获取对应类的对象
 * b. getConstructor(Class...clazz)：根据参数列表，获取对应的public 构造器对象
 * c. getDecalaredConstructor(Class...clazz)：根据参数列表，获取对应的构造器对象
 * 4. Constructor类相关方法
 * a. setAccessible：爆破
 * b. newInstance(Object..obj)：调用构造器
 */
public class RelectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1、获取到User对象
        Class<?> cls = Class.forName("com.shb.reflection.User");
        //2、通过无参构造器创建对象
        Object o = cls.newInstance();
        System.out.println(o);
        //3、通过有参构造器创建对象
        /**
         *    public User(String name) {
         *         this.name = name;
         *     }
         */
        //先得到构造器，在创建实例
        Constructor<?> constructor = cls.getConstructor(String.class);
        Object newInstance = constructor.newInstance("宋海波");
        System.out.println(newInstance);
        //4、通过非public的有参构造器创建对象
        Constructor<?> privateConstructor = cls.getDeclaredConstructor(int.class, String.class);
        //爆破  使用反射可以访问私有的构造器
        privateConstructor.setAccessible(true);
        Object newInstance1 = privateConstructor.newInstance(100, "李四");
        System.out.println(newInstance1);

    }

}

class User {
    private int age = 1;
    private String name = "小明";

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}