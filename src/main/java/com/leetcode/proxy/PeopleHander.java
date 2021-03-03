package com.leetcode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PeopleHander implements InvocationHandler {
    private Object target;

    public PeopleHander(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("管家服务");
        return method.invoke(target,args);
    }
}
