package com.thread.lp.deadlock;

import com.sun.javafx.tk.quantum.QuantumToolkit;
import com.thread.lp.sync2.lockstring.ThreadB;

public class DeadThread implements Runnable{
    private Object lock1 = new Object();
    private Object lock2 = new Object();


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("A")){
            synchronized (lock1){
                try {
                    System.out.println("ThreadName = " + Thread.currentThread().getName() + "get lock1");
                    Thread.sleep(2000);
                    synchronized (lock2){
                        System.out.println("ThreadName = " + Thread.currentThread().getName() + "get lock2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if(Thread.currentThread().getName().equals("B")){
            synchronized (lock2){
                try {
                    System.out.println("ThreadName = " + Thread.currentThread().getName() + "get lock2");
                    Thread.sleep(2000);
                    synchronized (lock1){
                        System.out.println("ThreadName = " + Thread.currentThread().getName() + "get lock1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadThread deadThread = new DeadThread();
        Thread threadA = new Thread(deadThread);
        Thread threadB = new Thread(deadThread);
        threadA.setName("A");
        threadB.setName("B");
        threadA.start();
        Thread.sleep(100);
        threadB.start();
    }
}
