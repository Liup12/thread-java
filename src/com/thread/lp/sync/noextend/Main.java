package com.thread.lp.sync.noextend;

/**
 * 同步方法不具备继承性,子类不会继承父类的同步方法
 */
public class Main {

    public synchronized void serviceMethod(){
        try {
            System.out.println(Thread.currentThread().getName()+"  main serviceMethod run time = " + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName()+"  main serviceMethod begin to sleep 5000ms");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+ "  main serviceMethod sleep end time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        ThreadA threadA = new ThreadA(sub);
        ThreadB threadB = new ThreadB(sub);
        threadA.start();
        threadB.start();
    }
}
