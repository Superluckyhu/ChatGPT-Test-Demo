package com.test.reflection.jdkdynamic;

/**
 * @ClassName MainTest
 * @Description TODO
 * @Author Superluckyhu
 * @Date 2023/3/8 13:31
 * @Version 1.0
 **/
public class MainTest {
    public static void main(String[] args) {
        SmsServiceImpl smsService = new SmsServiceImpl();
        SmsService proxy = (SmsService)ProxyFactory.getProxy(smsService);
        proxy.sendMsg("nihao");
    }
}
