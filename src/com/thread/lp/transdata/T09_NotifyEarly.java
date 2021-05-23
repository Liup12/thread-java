package com.thread.lp.transdata;

/**
 * 通知过早
 */
public class T09_NotifyEarly {
    private static String lock = new String("");

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + "在"+System.currentTimeMillis()+"s进入wait() ");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " 退出wait()");
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };

    private static Runnable runnable2 = new Runnable() {
        @Override
        public void run() {

                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + "在"+System.currentTimeMillis()+"s进入notify() ");
                    lock.notify();
                    System.out.println(Thread.currentThread().getName() + " 退出notify()");
                }

        }
    };

    public static void main(String[] args) throws InterruptedException {
        new Thread(runnable).start();
        Thread.sleep(200);
        new Thread(runnable2).start();
    }
}
