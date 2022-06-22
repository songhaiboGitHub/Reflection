package com.shb.reflection;

import java.lang.reflect.Field;

/**
 * 通过反射访问类中的成员
 */
public class ReflectAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //1、得到Student类对象
        Class<?> cls = Class.forName("com.shb.reflection.Student");
        //2、创建对象  o运行类型就是Student
        Object o = cls.newInstance();
        System.out.println(o);
        //3、使用反射操作成员变量  name  age
        Field age = cls.getField("age");
        age.set(o, 88);
        System.out.println(o);
        System.out.println(age.get(o));
        //4、使用反射操作name属性 私有的 静态的
        Field name = cls.getDeclaredField("name");
        //因为name是私有的无法设置值，所以对name进行爆破
        name.setAccessible(true);
        name.set(o, "宋海波");
        //应为name是静态的，所以对象写null也是可以的
        name.set(null, "宋海波");
        System.out.println(o);
        //静态的属性name    name.get(o)  name.get(null) 都可以的
        System.out.println(name.get(o));
    }
}

class Student {
    private static String name;
    public int age;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}