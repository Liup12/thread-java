package com.thread.lp.sync2.syncmethod;

public class ThreadB extends Thread {
    private Task task;

    public ThreadB(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doWork();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}
