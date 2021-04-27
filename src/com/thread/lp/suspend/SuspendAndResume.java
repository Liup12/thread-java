package com.thread.lp.suspend;

/**
 * 当线程对象执行了suspend()方法之后，线程被挂起。直到执行该线程对象的resume()方法重新唤醒对象
 */
public class SuspendAndResume extends Thread {

    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true){
            i++;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SuspendAndResume resume = new SuspendAndResume();
        resume.start();
        //暂停线程
        resume.suspend();
        Thread.sleep(5000);
        System.out.println("A = " + System.currentTimeMillis() + "   i  = " + resume.getI());
        Thread.sleep(5000);
        System.out.println("A = " + System.currentTimeMillis() + "   i  = " + resume.getI());

        //重新启动线程
        resume.resume();
        Thread.sleep(5000); //休眠主线程5000毫秒，让resume线程运行

        //暂停线程
        resume.suspend();

        //输出成员变量信息
        Thread.sleep(5000);
        System.out.println("B = " + System.currentTimeMillis() + "   i  = " + resume.getI());
        Thread.sleep(5000);
        System.out.println("B = " + System.currentTimeMillis() + "   i  = " + resume.getI());
    }
}
