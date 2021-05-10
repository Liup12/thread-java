package com.thread.lp.sync2.syncstatic;

/**
 * synchronized修饰静态方法锁的是当前对象的class
 * synchronized修饰非静态方法锁的是当前对象
 */
public class Service {
    public synchronized static void printA(){
        try {
            System.out.println("线程名称为=" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() +"进入printA方法");
            Thread.sleep(2000);
            System.out.println("线程名称为=" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() +"离开printA方法");
        }catch (InterruptedException e){
        }
    }

    public synchronized static void printB(){

        System.out.println("线程名称为=" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() +"进入printB方法");
        System.out.println("线程名称为=" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() +"离开printB方法");

    }

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        threadA.start();
        threadB.start();
    }
}
