package com.thread.lp.join;


/**
 * 本验证在join方法中被中断抛出InterruptionException
 * 线程B被线程C中断。线程B抛出异常，但是加入到线程B内的线程A还在运行，进程按钮还呈红色
 */
public class T02_Join_Interrupt {

    static class ThreadA extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                String string = new String();
                Math.random();
            }
            System.out.println("线程A运行结束");
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {

            try {
                ThreadA threadA = new ThreadA();
                threadA.start();
                threadA.join();
                System.out.println("线程B运行结束");
            } catch (InterruptedException e) {
                System.out.println("线程B进入catch语句块了");
                e.printStackTrace();
            }

        }
    }

    static class ThreadC extends Thread{
        private ThreadB threadB;

        public ThreadC(ThreadB threadB) {
            this.threadB = threadB;
        }

        @Override
        public void run() {
            threadB.interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadB threadB = new ThreadB();
        threadB.start();
        Thread.sleep(200);
        ThreadC threadC = new ThreadC(threadB);
        threadC.start();
    }
}
