package com.thread.lp.sync2.syncblock;

/**
 * methodA begin time = 1620626940398
 * methodA end time = 1620626942399
 * methodB begin time = 1620626942399
 * methodB end time = 1620626942399
 *
 * 当一个线程访问object的一个synchronize(this)代码块时，其他synchronize(this)代码块将会被阻塞
 */
public class Service {

    public void serviceMethodA(){

        try {
            synchronized (this){
                System.out.println("methodA begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("methodA end time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void serviceMethodB(){

        synchronized (this){
            System.out.println("methodB begin time = " + System.currentTimeMillis());
            System.out.println("methodB end time = " + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.start();
        threadB.start();
    }
}
