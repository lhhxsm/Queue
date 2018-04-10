package com.example.queue;

import java.util.concurrent.BlockingQueue;

/**
 * Create in 2018/4/10 21:49.
 *
 * @author lhh.  任务执行器
 */
public class TaskExecutor extends Thread {
    private BlockingQueue<Request> blockingQueue;
    private boolean isRunning = true;

    public TaskExecutor(BlockingQueue<Request> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    @Override
    public void run() {
        super.run();
        while (isRunning) {
            Request request = null;
            try {
                //take 是一个阻塞的方法,每次调用会拿到队列中的第一个任务,如果队列为空,这个方法将一直阻塞,直到队列中有任务返回
                request = blockingQueue.take();
            } catch (InterruptedException e) {
                return;
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(request.getName());
        }
    }
}
