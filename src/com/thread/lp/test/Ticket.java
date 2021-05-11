package com.thread.lp.test;



/**
 * 卖票小程序 3条线程同时卖30张票
 */
public class Ticket implements Runnable{

    private int count = 300;


    @Override
    public void run() {
        while (true){
            synchronized (this){
                if (count>0){
                    System.out.println("当前窗口: "+ Thread.currentThread().getName() + "已卖出第" + (300-(count--)+1) + "张票" );
                }else {
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(ticket);
            thread.setName("窗口"+ (i + 1));
            thread.start();
        }
    }
}
