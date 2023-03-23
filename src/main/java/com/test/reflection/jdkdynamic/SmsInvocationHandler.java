package com.test.reflection.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName SmsInvocationHandler
 * @Description TODO
 * @Author Superluckyhu
 * @Date 2023/3/8 13:26
 * @Version 1.0
 **/
public class SmsInvocationHandler implements InvocationHandler {

    private final Object target;
    public SmsInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method :"+method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method :"+method.getName());
        return result;
    }
}
