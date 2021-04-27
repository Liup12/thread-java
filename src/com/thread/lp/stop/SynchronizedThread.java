package com.thread.lp.stop;

/**
 * stop()方法极易造成数据不一致性问题，在JDK中被标注为作废的方法;
 */
public class SynchronizedThread extends Thread {
    private SynchronizedObject synchronizedObject;

    public SynchronizedThread(SynchronizedObject synchronizedObject) {
        this.synchronizedObject = synchronizedObject;
    }

    @Override
    public void run() {
        synchronizedObject.printString("bb","bbbb");
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject object = new SynchronizedObject();
        SynchronizedThread thread = new SynchronizedThread(object);
        thread.start();
        Thread.sleep(500);
        thread.stop();
        System.out.println(object.getName()+"======"+object.getPwd());
    }
}
