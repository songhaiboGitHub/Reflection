package com.shb.reflection.classload;

/**
 * 演示类加载 初始化
 */
public class ClassLoad03 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1、加载B类并生成B的实例对象
        //2、链接 num=0;
        //3、初始化
        //依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句，并进行合并。
        //        System.out.println(B.num);
        //
        //        System.out.println(new B());


        //看看加载类的时候是否有同步机制  是的 synchronized()同步块
        /*
        //对于某个类的Class类对象，在内存中只有一份，因为类只加载一次；正因为有这个机制，才能保证某个类在内存中只有一份这个class对象
         protected Class<?> loadClass(String name, boolean resolve)  throws ClassNotFoundException {
             synchronized (getClassLoadingLock(name)) {
              .....
            }
         }
        */
        B b = new B();
    }
}

class B {
    static {
        System.out.println("静态块被执行~");
        //先加载，后边被100覆盖了
        num = 300;
    }

    public static int num = 100;

    public B() {
        System.out.println("构造器执行~");
    }
}