package com.thread.lp.sync2.lockstring;

/**
 * String静态常量池带来的问题：
 * 使用同一个String对象作为锁对象，可能会导致其他线程获取不到这个锁对象
 */
public class LockString {
    public void lockStringMethod(String lockString){
        synchronized (lockString){
            while (true){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        LockString lockString = new LockString();
        ThreadA threadA = new ThreadA(lockString);
        ThreadB threadB = new ThreadB(lockString);
        threadA.setName("A");
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}
