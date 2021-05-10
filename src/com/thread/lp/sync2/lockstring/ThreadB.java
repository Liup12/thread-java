package com.thread.lp.sync2.lockstring;

public class ThreadB extends Thread {

    LockString lock = new LockString();

    public ThreadB(LockString lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lockStringMethod("AA");
    }
}
