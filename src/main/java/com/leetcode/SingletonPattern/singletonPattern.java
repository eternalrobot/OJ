package com.leetcode.SingletonPattern;

public class singletonPattern {
    private static volatile singletonPattern instance = null;
    private static final Object lock = new Object();

    public singletonPattern() {
    }

    public static singletonPattern getInstance() {
        if (null == instance) {
            synchronized (lock) {
                if (null == instance) instance = new singletonPattern();
            }
        }
        return instance;
    }
}
