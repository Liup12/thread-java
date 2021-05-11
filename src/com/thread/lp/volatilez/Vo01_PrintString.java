package com.thread.lp.volatilez;

/**
 * 停止线程Demo1
 */
public class Vo01_PrintString {

    private boolean isContinuePrint = true;

    public boolean isContinuePrint(){
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void stringPrint(){
        while (isContinuePrint){
            try {
                System.out.println("run stringPrint method ThreadName = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Vo01_PrintString printString = new Vo01_PrintString();
        printString.stringPrint();
        System.out.println("我要停止他，stop ThreadName = " + Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }
}
