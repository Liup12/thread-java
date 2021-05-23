package com.thread.lp.transdata.test;

/**
 * 20个线程交替打印 AAAAAAA,BBBBBB
 */
public class TestDemo {

    private static boolean isFirst = true;

    private static Object lock = new Object();
    public static void main(String[] args) {

        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock){
                        while (isFirst != true){
                            lock.wait();
                        }
                        for (int i = 0; i < 5; i++) {
                            System.out.println("AAAAAAAA");
                        }
                        isFirst = false;
                        lock.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock){
                        while (isFirst == true){
                            lock.wait();
                        }
                        for (int i = 0; i < 5; i++) {
                            System.out.println("BBBBBBBB");
                        }
                        isFirst = true;
                        lock.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnableA).start();
            new Thread(runnableB).start();
        }
    }
}
