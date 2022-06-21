package com.shb.reflection.classload;

public class ClassLoad02 {
    public static void main(String[] args) {

    }
}

class A {
    //类加载阶段不会加载，只有实例对象调用才会生效
    public int n1 = 10;
    //类加载阶段会加载应为是静态的，但是加载的时候n2是默认初始化0，而不是20
    public static int n2 = 20;
    //n3是final类型，一旦赋值不会改变，类加载阶段会加载，加载的时候n3就是30
    public static final int n3 = 30;
}
