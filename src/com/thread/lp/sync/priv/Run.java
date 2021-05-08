package com.thread.lp.sync.priv;

public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum num = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(num);
        ThreadB threadB = new ThreadB(num);
        threadA.start();
        threadB.start();
    }
}
