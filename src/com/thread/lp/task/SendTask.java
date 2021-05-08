package com.thread.lp.task;


import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
public class SendTask {
    public static void initQue() {
        try {
            for (int i = 0; i < TaskQueue.QUEUE_MAX_SIZE; i++) {
                TaskQueue.newInstance().produce(new TaskMsg("task_id_" + i, "VIN_" + i, "message_" + i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class StartTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TaskMsg taskMsg = TaskQueue.newInstance().consume();
                    if (taskMsg != null) {
                        System.out.println("当前线程: " + Thread.currentThread().getName());
                        System.out.println("当前下发任务===" + taskMsg.toString());
                        System.out.println("剩余任务总量" + TaskQueue.arrayBlockingQueue.size());
                        System.out.println();
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        initQue();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 30, 30, TimeUnit.SECONDS, TaskQueue.arrayBlockingQueue);
        threadPoolExecutor.submit(new StartTask());
        if (threadPoolExecutor.isShutdown()) {
            long e = System.currentTimeMillis();
            System.out.println("线程池运行耗时" + (e - l) + "ms");
        }
    }
}
