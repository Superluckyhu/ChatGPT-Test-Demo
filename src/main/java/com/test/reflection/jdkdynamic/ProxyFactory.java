package com.test.reflection.jdkdynamic;

import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyFactory
 * @Description TODO
 * @Author Superluckyhu
 * @Date 2023/3/8 13:29
 * @Version 1.0
 **/
public class ProxyFactory {
    public static Object getProxy(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),new SmsInvocationHandler(obj));
    }
}
