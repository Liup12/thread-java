package com.thread.lp.sync2.lockobject;

public class ThreadA extends Thread{
    private LockObject object;

    public ThreadA(LockObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.methodA();
    }
}
