package com.thread.lp.volatilez;

/**
 * 　　1）线程解锁前，必须把共享变量的最新值刷新到主内存中
 *
 * 　　2）线程加锁时，将清空工作内存中共享变量的值，从而使用共享变量时需要从主内存中重新获取最新的值
 */
public class Vo03_Volatile_Sync {

    private boolean isContinueRun = true;

    public void run(){

        while (isContinueRun){

        }
        System.out.println("停下来了");
    }

    public void stop(){
        isContinueRun = false;
    }


    static class ThreadA extends Thread{
        private Vo03_Volatile_Sync sync;

        public ThreadA(Vo03_Volatile_Sync sync) {
            this.sync = sync;

        }

        @Override
        public  void run() {

            sync.run();
        }
    }

    static class ThreadB extends Thread{
        private Vo03_Volatile_Sync sync;

        public ThreadB(Vo03_Volatile_Sync sync) {
            this.sync = sync;
        }

        @Override
        public void run() {
            sync.stop();
            System.out.println(Thread.currentThread().getName()+"已发起停止指令");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Vo03_Volatile_Sync s = new Vo03_Volatile_Sync();
        new ThreadA(s).start();
        Thread.sleep(200);
        new ThreadB(s).start();
    }
}
