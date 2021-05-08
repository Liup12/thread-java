package com.thread.lp.sync.reentrant;

public class Sub extends Main {
    public synchronized void operateSubMethod(){
        try {
            while (i>0){
                i--;
                System.out.println("sub print i  = " + i);
                Thread.sleep(100);
                this.operateMainMethod();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThread threadA = new MyThread();
        threadA.start();
    }
}
