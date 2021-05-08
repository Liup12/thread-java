package com.thread.lp.sync.priv;

public class ThreadA extends Thread{
    private HasSelfPrivateNum num;

    public ThreadA(HasSelfPrivateNum num) {
        this.num = num;
    }

    @Override
    public void run() {
        super.run();
        num.addI("a");
    }
}
