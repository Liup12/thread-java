package com.thread.lp.sync.twolock;

public class ThreadB extends Thread{

    private HasSelfPrivateNum num;

    public ThreadB(HasSelfPrivateNum num) {
        this.num = num;
    }

    @Override
    public void run() {
        super.run();
        num.addI("b");
    }
}
