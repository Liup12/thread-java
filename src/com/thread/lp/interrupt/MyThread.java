package com.thread.lp.interrupt;

/**
 * @author Administrator
 */
public class MyThread extends Thread {


    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("i = " + (i + 1));
        }
    }

    public static void dd() {
        System.out.println("dddd");
    }


}
