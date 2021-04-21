package com.thread.lp.task;

import javafx.concurrent.Task;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Administrator
 */
public class TaskQueue {

    /**
     * 队列大小
     */
    static final int QUEUE_MAX_SIZE   = 3000;

    /**
     * 任务队列
     */
    static ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<TaskMsg>(QUEUE_MAX_SIZE);

    public TaskQueue() {
    }

    private static class SingletonHolder{
        private static TaskQueue taskQueue = new TaskQueue();

    }

    public static TaskQueue newInstance(){
        return SingletonHolder.taskQueue;
    }

    /**
     * 生产入队
     */
    public  void  produce(TaskMsg taskMsg) throws InterruptedException {
        arrayBlockingQueue.put(taskMsg);
    }

    /**
     * 消费出队
     */
    public  TaskMsg consume() throws InterruptedException {
        return (TaskMsg) arrayBlockingQueue.take();
    }


}
