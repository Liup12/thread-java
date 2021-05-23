package com.thread.lp.transdata;


import java.util.ArrayList;
import java.util.List;

/**
 * 在多线程情况下，如果一个线程进入了if语句块中，在if语句块中执行了wait方法，该线程处于等待（wait）状态，如果该线程被唤醒（notify），
 * 不管if的条件是否发生了变化，该线程会执行wait之后的代码，并且会跳出if语句块执行if语句块外面的代码
 *
 * 如果是while，被唤醒了之后，会继续执行wait方法之后的代码，代码块里面的代码执行完了会继续判断条件，
 * 如果为true，会继续执行while语句块里面的代码，如果为false，才会执行判断语句块后面的代码
 *
 *
 * 简单理解为，while方法在执行一次循环之后，会重新执行一次判断条件，如果不成立将会终止循环
 * 而if在条件判断成立之后，退出if语句块也不会重新判断条件是否成立
 */
public class T10_WaitChange {
    static List list = new ArrayList<String>();
    static class Add{
        private String lock;

        public Add(String lock) {
            this.lock = lock;
        }

        public void Add(){
            synchronized (lock){


                System.out.println("添加元素");
                list.add("anyString");
                lock.notifyAll();


            }

        }

    }
    static boolean check(){
        System.out.println("调用了判断方法");
        return list.size() == 0;
    }
    static class SubStruct{
        private String lock;

        public SubStruct(String lock) {
            this.lock = lock;
        }

        public void subStruct(){
            try{
                synchronized (lock){
                    while (check()){
                        System.out.println("当前list集合中size为0,等待集合添加元素" + Thread.currentThread().getName());
                        lock.wait();
                        System.out.println("集合添加元素完成，完成等待" + Thread.currentThread().getName());
                    }
                    System.out.println("执行删除");
                    list.remove(0);
                    System.out.println("删除成功，当前集合的size为："+ list.size() + Thread.currentThread().getName());
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread{
        private Add add;

        public ThreadA(Add add) {
            this.add = add;
        }

        @Override
        public void run() {
            add.Add();
        }
    }

    static class ThreadB extends Thread{
        private SubStruct subStruct;

        public ThreadB(SubStruct subStruct) {
            this.subStruct = subStruct;
        }

        @Override
        public void run() {
            subStruct.subStruct();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Add add = new Add(lock);
        SubStruct subStruct = new SubStruct(lock);

        ThreadA threadA = new ThreadA(add);

        ThreadB threadB = new ThreadB(subStruct);
        ThreadB threadC = new ThreadB(subStruct);
        /*threadC.start();
        threadC.setName("ThreadC");*/
        threadB.start();
        threadB.setName("ThreadB");

        Thread.sleep(2000);
        threadA.start();
        threadA.setName("ThreadA");
    }
}
