package com.thread.lp.sync2.syncorder;

public class ThreadA extends Thread {
    private MyList list;

    public ThreadA(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            list.add("ThreadA-"+ i);
        }
    }
}
