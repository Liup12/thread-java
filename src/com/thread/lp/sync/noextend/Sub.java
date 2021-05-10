package com.thread.lp.sync.noextend;

public class Sub extends Main {
    @Override
    public synchronized void serviceMethod() {
        try {
            System.out.println("sub serviceMethod sleep start time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("sub serviceMethod sleep end time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
