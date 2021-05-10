package com.thread.lp.sync2.lockobject;

/**
 * synchronize和synchronize(this) 都是锁定的当前对象
 */
public class LockObject {
    public void methodA(){
        synchronized (this){
            for (int i = 0; i < 1000; i++) {
                System.out.println("current thread name  = " + Thread.currentThread().getName() +"  i = " + i);
            }
        }
    }

    public synchronized void methodB(){
        System.out.println("-------------------------------run methodB--------------------------------------");
    }

    public static void main(String[] args) throws InterruptedException {
        LockObject object = new LockObject();
        Thread threadA = new ThreadA(object);
        Thread threadB = new ThreadB(object);
        threadA.start();
        Thread.sleep(6);
        threadB.start();
    }
}
