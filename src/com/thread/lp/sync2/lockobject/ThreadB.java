package com.thread.lp.sync2.lockobject;

public class ThreadB extends Thread {
    private LockObject object;

    public ThreadB(LockObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.methodB();
    }
}
