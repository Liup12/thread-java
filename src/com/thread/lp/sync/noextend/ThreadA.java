package com.thread.lp.sync.noextend;

public class ThreadA extends Thread{
    private Sub sub;

    public ThreadA(Sub sub) {
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
