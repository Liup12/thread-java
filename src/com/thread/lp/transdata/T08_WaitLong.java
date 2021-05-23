package com.thread.lp.transdata;

/**
 * 设置等待时间，过期自动唤醒,也可以在等待期间由其他线程唤醒
 */
public class T08_WaitLong {


    private static Object lock = new Object();
    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock){
                    System.out.println("begin wait() time = " + System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println("end wait() time = " + System.currentTimeMillis());
                }
            }catch (InterruptedException e){
                System.out.println("程序进入异常");
            }
        }
    };

    private static Runnable runnable2 = new Runnable() {
        @Override
        public void run() {

            synchronized (lock) {
                lock.notifyAll();
            }
        }
    };
    public static void main(String[] args) {
        Thread thread = new Thread(runnable);
        thread.start();
        Thread thread1 = new Thread(runnable2);
        thread1.start();
    }
}
