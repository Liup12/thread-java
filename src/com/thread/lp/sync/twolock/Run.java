package com.thread.lp.sync.twolock;

/**
 * 使用多个对象实例，创建多个锁，异步执行synchronize方法
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum num = new HasSelfPrivateNum();
        HasSelfPrivateNum num2 = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(num);
        ThreadB threadB = new ThreadB(num2);
        threadA.start();
        threadB.start();
    }
}
