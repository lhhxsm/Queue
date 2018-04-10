package com.example.queue;

import android.support.annotation.NonNull;

/**
 * Create in 2018/4/10 21:52.
 *
 * @author lhh.
 * <p>要去执行的任务</p>
 */
public class Request implements Comparable<Request> {

    private String name;
    private Priority priority = Priority.B;
    private int order;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int compareTo(@NonNull Request o) {
        // 返回正数代表1排在2后面，返回负数表示1排在2前面
        Priority priority = getPriority();// 拿到自身的优先级
        Priority oPriority = o.getPriority();
        return priority == oPriority ? getOrder() - o.getOrder() : oPriority.ordinal() - priority.ordinal();
        //        return 0;
    }
}
