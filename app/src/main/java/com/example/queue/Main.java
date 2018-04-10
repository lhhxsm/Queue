package com.example.queue;

/**
 * Create in 2018/4/10 22:02.
 *
 * @author lhh.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    /**
     * 程序入口
     */
    public void start() {
        //先进先出队列
        //        MyLinkedQueue queue = new MyLinkedQueue(3);
        //        queue.start();

        //无序队列
        MyPriorityQueue queue = new MyPriorityQueue(1);
        queue.start();


        //往队列中添加请求
        for (int i = 0; i < 20; i++) {
            Request request = new Request("请求" + i);
            if (i == 10)
                request.setPriority(Priority.C);
            if (i == 15)
                request.setPriority(Priority.D);
            queue.add(request);
        }

    }
}
