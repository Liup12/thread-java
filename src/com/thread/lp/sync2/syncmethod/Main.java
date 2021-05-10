package com.thread.lp.sync2.syncmethod;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        ThreadA threadA = new ThreadA(task);
        ThreadB threadB = new ThreadB(task);
        threadA.start();
        threadB.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long startTime = CommonUtils.beginTime1;
        long endTime = CommonUtils.endTime1;

        if (CommonUtils.beginTime1 > CommonUtils.beginTime2){
            startTime = CommonUtils.beginTime2;
        }
        if (CommonUtils.endTime1 < CommonUtils.endTime2){
            endTime = CommonUtils.endTime2;
        }

        System.out.println("总耗时:" + (endTime-startTime)/1000);
    }
}
