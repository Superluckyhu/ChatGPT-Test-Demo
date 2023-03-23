package com.test.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Superluckyhu
 * @Date 2023/3/8 10:18
 * @Version 1.0
 **/
public class Test implements InvocationHandler {

    private final Object target;

    public Test(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(target, args);

        return result;
    }
}
