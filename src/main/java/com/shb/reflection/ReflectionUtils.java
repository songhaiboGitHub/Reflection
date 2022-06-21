package com.shb.reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射获取类的结构信息 API
 */
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    @Test
    public void api_01() throws ClassNotFoundException, IllegalAccessException {
        //得到Class对象
        Class<?> personClass = Class.forName("com.shb.reflection.Person");
        //        1. getName：获取全类名
        System.out.println(personClass.getName());
        //        2. getSimpleName：获取简单类名
        System.out.println(personClass.getSimpleName());
        //        3. getFields：获取所有public修饰的属性，包含本类以及父类的
        for (Field field : personClass.getFields()) {
            System.out.println(field.getName());
        }
        //        4. getDeclaredFields：获取本类中所有属性
        for (Field declaredField : personClass.getDeclaredFields()) {
            System.out.println(declaredField.getName());
        }
        //        5. getMethods：获取所有public修饰的方法，包含本类以及父类的
        for (Method method : personClass.getMethods()) {
            System.out.println(method.getName());
        }
        //        6. getDeclaredMethods：获取本类中所有方法
        for (Method declaredMethod : personClass.getDeclaredMethods()) {
            System.out.println(declaredMethod.getName());
        }
        //        7. getConstructors：获取所有public修饰的构造器，包含本类以及父类的
        for (Constructor<?> constructor : personClass.getConstructors()) {
            System.out.println(constructor.getName());
        }
        //        8. getDeclaredConstructors：获取本类中所有构造器
        for (Constructor<?> declaredConstructor : personClass.getDeclaredConstructors()) {
            System.out.println(declaredConstructor.getName());
        }
        //        9. getPackage：以Package形式返回 包信息
        System.out.println(personClass.getPackage());
        //        10. getSuperClass：以Class形式返回父类信息
        System.out.println(personClass.getSuperclass());
        //        11. getInterfaces：以Class[]形式返回接口信息
        for (Class<?> anInterface : personClass.getInterfaces()) {
            System.out.println(anInterface.getName());
        }
        //        12. getAnnotations：以Annotation[]形式返回注解信息
        for (Annotation annotation : personClass.getAnnotations()) {
            System.out.println(annotation.getClass());
        }

    }
}

class Person {
    //属性
    public String name;
    protected int age;
    String job;
    private double sar;

    //方法
    public void m1() {

    }

    @Deprecated
    private void m2() {

    }

    protected void m3() {

    }

    void m4() {

    }

}