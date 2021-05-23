package com.thread.lp.transdata;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用sleep()结合死循环实现线程通信
 */
public class T01_NoWait {


        private List list = new ArrayList();

        public void add(String name){
            list.add(name);
        }

        public int size(){
            return list.size();
        }



    static class ThreadA extends Thread{

        private T01_NoWait list;

        public ThreadA(T01_NoWait list) {
            this.list = list;
        }

        @Override
        public void run() {


                try {
                    for (int i = 0; i < 10 ; i++) {
                        list.add("ddddd");
                        System.out.println("添加了" + list.size() + "个元素");
                        Thread.sleep(1000);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }
    
    static class ThreadB extends Thread{
        private T01_NoWait list;

        public ThreadB(T01_NoWait list) {
            this.list = list;
        }


        @Override
        public void run() {
            while (true){
                if (list.size() > 6){
                    System.out.println("当前list的size"+ list.size());
                    System.out.println("线程B退出了");
                    try {
                        throw new InterruptedException();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        T01_NoWait myList = new T01_NoWait();
        new ThreadA(myList).start();
        new ThreadB(myList).start();
    }

}
