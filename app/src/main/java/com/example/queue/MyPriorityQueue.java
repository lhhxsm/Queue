package com.example.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create in 2018/4/10 21:58.
 *
 * @author lhh. 无序队列
 */
public class MyPriorityQueue {
    private BlockingQueue<Request> blockingQueue;
    private TaskExecutor[] taskExecutors;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public MyPriorityQueue(int poolSize) {
        // 如果Comparable#compareTo(Object)方法不做比较返回0，那么是无序的
        blockingQueue = new PriorityBlockingQueue<>();
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
        request.setOrder(atomicInteger.incrementAndGet());
        blockingQueue.add(request);
    }
}
