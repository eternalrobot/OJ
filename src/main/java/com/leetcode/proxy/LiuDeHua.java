package com.leetcode.proxy;

public class LiuDeHua implements Star,People{

    @Override
    public String sing(String name)
    {
        System.out.println("唱"+name);

        return "唱完" ;
    }

    @Override
    public String dance(String name)
    {
        System.out.println("跳"+name);

        return "跳完" ;
    }

    public String entertainment(String name){
        System.out.println("玩"+name);
        return "玩完";
    }


    @Override
    public String eat(String name) {
        System.out.println("吃"+name);
        return "吃完";
    }
}
