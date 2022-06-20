package com.shb.reflection.class_;

import com.shb.Cat;

/**
 * 演示得到Class对象的各种方式（6）
 */
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
//        1. 前提：已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName（）获取。
//  ○ 应用场景：多用于配置文件，读取类全路径，加载类。
//  ○ 阶段：代码阶段/编译阶段  Class.forName()
        String filePath = "com.shb.Cat";//通过配置文件读取到的路径
        Class<?> cls1 = Class.forName(filePath);
        System.out.println(cls1);
//        2. 前提：若已知具体的类，通过类的class获取，该方式 最为安全可靠，程序性能最高实例：Class cls=Cat.class;
//  ○ 应用场景：多用于参数传递，比如通过反射得到对应构造器对象。
        Class<Cat> cls2 = Cat.class;
        System.out.println(cls2);
//  ○ 阶段：加载阶段 类.class
//        3. 前提：已知某个类的实例，调用改实例的getClass()方法获取Class对象，实例：Class class= 对象.getClass()；
//  ○ 应用场景：通过创建好的对象，获取Class对象。
//  ○ 阶段：运行阶段 对象.getClass()
        Cat cat = new Cat();
        Class<? extends Cat> cls3 = cat.getClass();
        System.out.println(cls3);
//        4. 其他方式 类加载器 得到Class对象
//  ○ ClassLoader cl=对象.getClass().getClassLoader();
//  ○ Class clazz4=cl.loadClass("类的全类名");
        //(1)先得到Cat类加载器
        ClassLoader classLoader = cat.getClass().getClassLoader();
        //(2)通过类加载器得到对象
        Class<?> cls4 = classLoader.loadClass("com.shb.Cat");
        System.out.println(cls4);

        // cls1 cls2 cls3 cls4 其实是同一个对象
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

//        5. 基本数据类型得到Class对象
//  ○ Class cls= 基本数据类型.class
//  ○ 阶段：加载阶段 类.class
        Class<Integer> cls5 = int.class;
        System.out.println(cls5);
//        6. 基本数据类型对应的包装类，可以通过.type得到Class类对象
//  ○ Class cls=包装类.TYPE
//  ○ 阶段：加载阶段 类.class
        Class<Integer> cls6 = Integer.TYPE;
        System.out.println(cls6);
        //一样的
        System.out.println(cls5.hashCode() == cls6.hashCode());

    }
}
