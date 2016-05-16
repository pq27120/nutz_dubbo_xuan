package com.xuan.service.jpush.services;

import com.xuan.smzdm.services.impl.PushServiceImpl;

/**
 * Created by bj on 2016/5/6.
 */
public class JpushServer {
    public static void main(String[] args) {
//        String[] names = JPUSH_IOC.getNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
        PushServiceImpl pushService = new PushServiceImpl();
        pushService.alert(1,"1",null);
    }
}
