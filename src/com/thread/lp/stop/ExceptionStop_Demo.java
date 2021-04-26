package com.thread.lp.stop;


/**
 * 异常退出当前线程
 *
 */
public class ExceptionStop_Demo extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
                //this 为当前线程对象
                if (this.isInterrupted()){
                    System.out.println("当前线程中断了,让开,我要退出循环了！！！");
                    throw new InterruptedException();
                }
                System.out.println("i = "+ i);

            }
            System.out.println("我是在for循环外面输出的,如果你看到了我,那就证明当前线程并没有退出.......");

        } catch (InterruptedException e) {
            System.out.println("进入了run方的catch语句块");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExceptionStop_Demo thread = new ExceptionStop_Demo();
        thread.setName("ExceptionStop_Demo");
        thread.start();
        try {
            Thread.sleep(20);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
