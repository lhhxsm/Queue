package com.example.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Create in 2018/4/10 21:58.
 *
 * @author lhh.  先进先出队列
 */
public class MyLinkedQueue {
    private BlockingQueue<Request> blockingQueue;
    private TaskExecutor[] taskExecutors;

    public MyLinkedQueue(int poolSize) {
        //LinkedBlockingQueue 是一个先进先出的队列
        blockingQueue = new LinkedBlockingQueue<>();
        taskExecutors = new TaskExecutor[poolSize];
    }

    public void start() {
        for (int i = 0; i < taskExecutors.length; i++) {
            taskExecutors[i] = new TaskExecutor(blockingQueue);
            taskExecutors[i].start();
        }
    }

    public void stop() {
        for (TaskExecutor taskExecutor : taskExecutors) {
            taskExecutor.setRunning(false);
            taskExecutor.interrupt();
        }
    }

    public void add(Request request) {
        blockingQueue.add(request);
    }
}
