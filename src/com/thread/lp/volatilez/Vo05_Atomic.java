package com.thread.lp.volatilez;

import java.util.concurrent.atomic.AtomicInteger;

public class Vo05_Atomic implements Runnable{


    private AtomicInteger atomicInteger = new AtomicInteger();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(atomicInteger.incrementAndGet());
        }
    }

    public static void main(String[] args) {
        Vo05_Atomic vo05_atomic = new Vo05_Atomic();
        for (int i = 0; i < 100; i++) {
            new Thread(vo05_atomic).start();
        }
    }
}
