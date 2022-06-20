package com.shb.reflection.class_;

/**
 * 对Class类的特点梳理
 */
public class Class {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. Class也是类，因此也继承Object类
        //看下Class类的类图
        Class cls;
        //2. Class类对象不是new出来的，而是系统创建的
        //（1）传统方法new
                 /* ClassLoader类
                  public Class<?> loadClass(String name) throws ClassNotFoundException {
                  return loadClass(name, false);
                }*/
//        Cat cat = new Cat();
        //(2)反射方式
                /* 先走forName，最后也是ClassClassLoader类
                    public Class<?> loadClass(String name) throws ClassNotFoundException {
                     return loadClass(name, false);
                 }*/
        java.lang.Class<?> cls01 = java.lang.Class.forName("com.shb.Cat");
        //3. 对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
        java.lang.Class<?> cls02 = java.lang.Class.forName("com.shb.Cat");
        System.out.println(cls01.hashCode() == cls02.hashCode());
        java.lang.Class<?> cls03 = java.lang.Class.forName("com.shb.Dog");
        System.out.println(cls03.hashCode());
        //4. 每个类的实例都会记得自己是由哪个Class实例所生成
        //5. 通过Class可以完整地得到一个类的完整结构，通过一系列API
        //6. Class对象是存放在堆的
        //7. 类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据
    }
}
