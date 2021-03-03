package com.leetcode.proxy;

import java.lang.reflect.Proxy;

/**
 *
 */
//23种设计模式之代理模式设计模式
public class Main {
    public static void main(String[] args){
        LiuDeHua liuDeHua=new LiuDeHua();//或者Star star=new LiuDeHua();
        var StarHandler=new StarHandler(liuDeHua);
        var PeopleHandler=new PeopleHander(liuDeHua);
        //经纪人
        var starproxy= Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class},StarHandler);
        //管家
        var peopleproxy=Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{People.class},PeopleHandler);
        System.out.println(starproxy.getClass().getName());
        System.out.println(peopleproxy.getClass().getName());
        Star star=(Star) starproxy;
        People people=(People)peopleproxy;
        System.out.println(star.dance("街舞"));
        StarHandler.setTarget(new DuYuHui());//动态设置代理不同对象
        System.out.println(star.dance("街舞"));
        System.out.println(people.eat("牛排"));
        System.out.println(liuDeHua.entertainment("游戏机"));
        System.out.println(liuDeHua.dance("现代舞"));
    }
}
