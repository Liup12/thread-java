package com.thread.lp.sync2.syncorder;

public class ThreadB extends Thread {
    private MyList list;
    public ThreadB(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            list.add("ThreadB-"+ i);
        }
    }
}
