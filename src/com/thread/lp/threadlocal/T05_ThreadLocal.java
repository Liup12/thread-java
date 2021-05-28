package com.thread.lp.threadlocal;

/**
 * 子线程会继承主线程中 InheritableThreadLocal的value
 * @author liupei
 * @version 1.0
 * @date 2021/5/28 11:17
 */
public class T05_ThreadLocal {


    private static InheritableThreadLocal threadLocal = new InheritableThreadLocalEx();

    static class InheritableThreadLocalEx extends InheritableThreadLocal{
        @Override
        protected Object initialValue() {
            return System.currentTimeMillis();
        }

        @Override
        protected Object childValue(Object parentValue) {
            return parentValue + "chileThread Add";
        }
    }


    static class ThreadA extends Thread{
        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {

                    System.out.println("ThreadA get value = " + threadLocal.get());
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < 100; i++) {

            System.out.println("Main get value = " + threadLocal.get());
        }

        Thread.sleep(200);

        new ThreadA().start();
    }


}