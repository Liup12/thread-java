package com.thread.lp.volatilez;

/**
 * -server启动，isContinuePrint为线程私有，线程死循环
 */
public class Vo02_PrintString implements Runnable{

    private boolean isContinuePrint = true;

    public boolean isContinuePrint(){
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        this.isContinuePrint = continuePrint;
    }

    public void stringPrint(){
        while (isContinuePrint){

        }
    }

    public void stop(){
        this.isContinuePrint = false;
    }



    public static void main(String[] args) throws InterruptedException {
        Vo02_PrintString printString = new Vo02_PrintString();
        new Thread(printString).start();
        Thread.sleep(2000);
        System.out.println("我要停止他，stop ThreadName = " + Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }


    @Override
    public void run() {
        stringPrint();
    }
}
