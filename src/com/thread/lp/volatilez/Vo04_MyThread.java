package com.thread.lp.volatilez;

/**
 * volatile只能保证可见性，不能保证原子性
 * synchronized 既能保证可见性，也能保证原子性
 */
public class Vo04_MyThread implements Runnable {
    public volatile int count;

     private void addCount(){
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("thread name = "+Thread.currentThread().getName() +  "   count = " + count);
    }

    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] args) {
        Vo04_MyThread vo04_myThread = new Vo04_MyThread();
        for (int i = 0; i < 100; i++) {
            new Thread(vo04_myThread).start();
        }
    }
}
