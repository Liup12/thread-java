package com.thread.lp.sync.reentrant;

/**
 * threadA线程首先调用service1方法，获得该对象的锁，但service1方法还未执行完，对象锁未被释放，需要执行该对象的另外一个synchronize方法，容易造成死锁
 *
 * 可重入锁： 自己可以依次获取自己内部的锁，虽然service1()方法的锁还未释放，当threadA要执行service2()方法还是可以获取到改对象的锁（仅同一个线程）
 */
public class Service {

    public synchronized void service1(){
        System.out.println("Thread name = "+Thread.currentThread().getName()+"    service1");
        service2();
    }

    public synchronized void service2(){
        System.out.println("Thread name = "+Thread.currentThread().getName()+"    service2");
        service3();
    }

    public synchronized void service3(){
        System.out.println("Thread name = "+Thread.currentThread().getName()+"    service3");
    }

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        ThreadA threadB = new ThreadA(service);
        threadB.setName("B");
        threadA.start();
        threadB.start();

    }
}
