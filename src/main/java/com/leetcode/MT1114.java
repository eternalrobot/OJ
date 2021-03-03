package com.leetcode;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo {
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        new Thread(printFirst).start();
//        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        new Thread(printSecond).start();
//        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        new Thread(printThird).start();
//        printThird.run();
    }
}

public class MT1114 {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        int AInt = in.nextInt();
        int BInt = in.nextInt();
        int CInt = in.nextInt();
        int[] ABC = new int[]{AInt, BInt, CInt};
        BlockingQueue blockingQueue=new LinkedBlockingQueue();
        Lock lock=new ReentrantLock();
        blockingQueue.add("1");
        for (int i : ABC) {
            if (i == 1) {
                new Foo().first(() -> {
                    while (true) {
                        lock.lock();
                        String t= (String) blockingQueue.peek();
                        if(t==null){}
                        else if(t.equals("1")){
                            System.out.print("first");
                            blockingQueue.poll();
                            blockingQueue.add("2");
                        }
                        lock.unlock();
                    }
                });
            } else if (i == 2) {
                new Foo().second(() -> {
                    while (true) {
                        lock.lock();
                        String t= (String) blockingQueue.peek();
                        if(t==null){}
                        else if(t.equals("2")){
                            System.out.print("second");
                            blockingQueue.poll();
                            blockingQueue.add("3");
                        }
                        lock.unlock();
                    }
                });
            } else {
                new Foo().third(() -> {
                    while (true) {
                        lock.lock();
                        String t= (String) blockingQueue.peek();
                        if(t==null){}
                        else if(t.equals("3")){
                            System.out.print("third");
                            blockingQueue.poll();
                            blockingQueue.add("1");
                        }
                        lock.unlock();
                    }
                });
            }
        }
    }
}
