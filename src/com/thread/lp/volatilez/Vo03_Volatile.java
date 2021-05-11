package com.thread.lp.volatilez;

import java.util.concurrent.CountDownLatch;

public class Vo03_Volatile implements Runnable{

    private volatile int count = 0;

    @Override
    public void run() {
        while (count<100){
            System.out.println("ThreadName = " + Thread.currentThread().getName() + "  count = "+ count++);

        }
    }

    public static void main(String[] args) {
        Vo03_Volatile aVolatile = new Vo03_Volatile();
        new Thread(aVolatile).start();
        new Thread(aVolatile).start();
    }
}
