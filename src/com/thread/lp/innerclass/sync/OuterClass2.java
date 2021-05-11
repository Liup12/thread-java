package com.thread.lp.innerclass.sync;


public class OuterClass2 {



    static class InnerClass2_1{
        public void method1(InnerClass2_2 innerClass){
            synchronized (innerClass){
                System.out.println(Thread.currentThread().getName() + "进入InnerClass2_1的method1方法");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "离开InnerClass2_1的method1方法");
            }
        }

        public synchronized void method2(){
            System.out.println(Thread.currentThread().getName() + "进入InnerClass2_1的method2方法");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "离开InnerClass2_1的method2方法");
        }
    }

    static class InnerClass2_2{
        public synchronized void method1(){
            System.out.println(Thread.currentThread().getName() + "进入InnerClass2_2的method1方法");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "离开InnerClass2_2的method1方法");
        }

    }

    public static void main(String[] args) {
        InnerClass2_1 innerClass2_1 = new InnerClass2_1();
        InnerClass2_2 innerClass2_2 = new InnerClass2_2();
        new Thread(()->{
            innerClass2_1.method1(innerClass2_2);
        },"A").start();

        new Thread(()->{
            innerClass2_1.method2();
        },"B").start();

        new Thread(()->{
            innerClass2_2.method1();
        },"C").start();
    }
}
