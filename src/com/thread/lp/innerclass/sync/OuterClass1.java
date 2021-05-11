package com.thread.lp.innerclass.sync;

public class OuterClass1 {
    static class InnerClass1{
        public void method1(){
            synchronized (new Object()){
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "  i =" + i);
                }
            }
        }

        public synchronized void method2(){
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + "  i =" + i);
            }
        }
    }

    public static void main(String[] args) {
        InnerClass1 innerClass1 = new InnerClass1();
        new Thread(()->{
            innerClass1.method1();
        },"A").start();

        new Thread(()->{
            innerClass1.method2();
        },"B").start();
    }
}
