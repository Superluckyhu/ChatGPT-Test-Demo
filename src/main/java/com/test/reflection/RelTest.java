package com.test.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName RelTest
 * @Description TODO
 * @Author Superluckyhu
 * @Date 2023/3/8 12:50
 * @Version 1.0
 **/
public class RelTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> clazz = Class.forName("com.test.reflection.TargetObject");
        TargetObject targetObject = (TargetObject)clazz.newInstance();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

        Method publicMethod = clazz.getDeclaredMethod("publicMethod",String.class);
        publicMethod.invoke(targetObject,"nihao");

        Field value = clazz.getDeclaredField("value");
        value.setAccessible(true);
        value.set(targetObject,"ceshi");

        Method privateMethod = clazz.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);


    }
}
