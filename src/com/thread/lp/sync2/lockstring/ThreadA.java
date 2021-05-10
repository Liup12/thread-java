package com.thread.lp.sync2.lockstring;

public class ThreadA extends Thread {
    LockString lock = new LockString();

    public ThreadA(LockString lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lockStringMethod("AA");
    }
}
