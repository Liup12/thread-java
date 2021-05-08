package com.thread.lp.sync.twolock;

public class HasSelfPrivateNum {
    //线程不安全
    int num = 0;
    public synchronized void addI(String username){
        try {
            // 线程安全
            //int num = 0;
            if (username.equals("a")){
                num = 100;
                System.out.println("a set over");
                Thread.sleep(2000);
            }else {
                num = 200;
                System.out.println("b set over");
            }
            System.out.println(username + " = " + num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
