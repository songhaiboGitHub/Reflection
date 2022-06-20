package com.shb.reflection.class_;

import com.shb.Car;

import java.lang.reflect.Field;

/**
 * Class常用api示例
 */
public class ClassApi {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String classAllPath = "com.shb.Car";
        //1、获取Car类对象
        Class<?> cls = Class.forName(classAllPath);
        //2、输出cls
        System.out.println(cls);  //是哪个类型 cls
        System.out.println(cls.getClass());  //运行类型
        //3、获取包名
        System.out.println(cls.getPackage().getName());
        //4、获取全类名
        System.out.println(cls.getName());
        //5、生成对象实例
        Object o = cls.newInstance();
        Car car = (Car) o;
        System.out.println(car);
        //6、通过反射获取属性 不能获取私有属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));
        //7、通过反射给属性设置值
        brand.set(car, "奥迪");
        System.out.println(brand.get(car));
        //8、得到所有的属性 只能得到公共的
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field.toString());
        }
        //9、得到所有的属性包括私有的 getDeclaredFields
        for (Field declaredField : cls.getDeclaredFields()) {
            System.out.println(declaredField.toString());
        }

    }
}
