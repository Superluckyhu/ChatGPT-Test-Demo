package com.test.reflection;

/**
 * @ClassName TargetObject
 * @Description TODO
 * @Author Superluckyhu
 * @Date 2023/3/8 12:50
 * @Version 1.0
 **/
public class TargetObject {
    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
