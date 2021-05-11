package com.thread.lp.test;

public class Ticket2 {
    private int count  = 300;

    public void sell(){
        System.out.println("当前窗口: "+ Thread.currentThread().getName() + "已卖出第" + (300-(count--)+1) + "张票" );
    }

    public static void main(String[] args) {
        Ticket2 ticket2 = new Ticket2();
        for (int i = 0; i < 3; i++) {
            new Thread(() ->{
                while (true){
                    synchronized (ticket2){
                        if (ticket2.count>0){
                            ticket2.sell();
                        }else{
                            break;
                        }
                    }
                }
            }).start();
        }
    }
}
