package com.leetcode.proxy;

public class DuYuHui implements Star{
    @Override
    public String sing(String name)
    {
        System.out.println("唱不来");

        return "唱完" ;
    }

    @Override
    public String dance(String name)
    {
        System.out.println("跳不来");

        return "跳完" ;
    }
}
