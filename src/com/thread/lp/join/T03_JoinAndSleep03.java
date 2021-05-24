package com.thread.lp.join;

/**
 * join(long)与sleep(long)的区别
 * sleep不释放锁
 * join内部使用wait方法，释放锁
 */
public class T03_JoinAndSleep03 {

    static class ThreadA extends Thread{
        private ThreadB threadB;

        public ThreadA(ThreadB threadB) {
            this.threadB = threadB;
        }

        @Override
        public void run() {
            try {
                synchronized (threadB){
                    threadB.start();
                    threadB.join(6000);
                    System.out.println("线程A执行结束");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {

            try {
                System.out.println(" b run begin time =" + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println(" b run end time =" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized public void bService(){
            System.out.println("打印了ThreadB的service方法");
        }
    }

    static class ThreadC extends Thread{
        private ThreadB threadB;

        public ThreadC(ThreadB threadB) {
            this.threadB = threadB;
        }

        @Override
        public void run() {
            threadB.bService();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadB threadB = new ThreadB();
        ThreadA threadA = new ThreadA(threadB);
        ThreadC threadC = new ThreadC(threadB);
        threadA.start();
        Thread.sleep(1000);
        threadC.start();
    }
}
