package com.leetcode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StarHandler implements InvocationHandler {
    // 目标类，也就是被代理对象
    private Object target;

    //可以动态的处理不同的对象，比如我先代理LiuDeHua然后代理DuYuHui
    public void setTarget(Object target)
    {
        this.target = target;
    }

    public StarHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("收钱");
//        下面这个调用后，又会继续使用invoke方法，导致无法跳出循环，这个proxy就是newProxyInstance返回的proxy
//        Star star=(Star)proxy;
//        star.dance("街舞");
        return method.invoke(target,args);
    }
}
