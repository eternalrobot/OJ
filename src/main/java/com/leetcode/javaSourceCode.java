package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class javaSourceCodeThread extends Thread {

    private static int javaSCTID = 0;

    private static synchronized int getJavaSCTID() {
        javaSCTID++;
        return javaSCTID;
    }

    private static Integer flag = 0;
    ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> getJavaSCTID());
    private static Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            while (!flag.equals(integerThreadLocal.get() - 1)) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(""+integerThreadLocal.get()+",");
            flag++;
            lock.notifyAll();
        }
    }
}

public class javaSourceCode {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable<Boolean> task= new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                System.out.println(Thread.currentThread().getName());
//                new javaSourceCodeThread().run();
                return true;
            }
        };
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        CompletableFuture completableFuture = null;
        for(int i=0;i<1000;i++){
            completableFuture=CompletableFuture.supplyAsync(()->{
//                System.out.println(Thread.currentThread().getName());
                new javaSourceCodeThread().run();
                return true;
            },executorService);
        }
        executorService.shutdown();
    }
}
