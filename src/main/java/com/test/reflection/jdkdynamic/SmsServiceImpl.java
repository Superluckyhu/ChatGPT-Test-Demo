package com.test.reflection.jdkdynamic;

/**
 * @ClassName SmsServiceImpl
 * @Description TODO
 * @Author Superluckyhu
 * @Date 2023/3/8 13:24
 * @Version 1.0
 **/
public class SmsServiceImpl implements SmsService{
    @Override
    public String sendMsg(String msg) {
        System.out.println("send Msg:"+msg);
        return msg;
    }
}
