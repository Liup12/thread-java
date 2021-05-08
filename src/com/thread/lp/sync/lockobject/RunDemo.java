package com.thread.lp.sync.lockobject;

public class RunDemo {
    public static void main(String[] args) {
        MyObject object = new MyObject();
        Thread threadA = new ThreadA(object);
        Thread threadB = new ThreadB(object);
        threadA.setName("A");
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}
