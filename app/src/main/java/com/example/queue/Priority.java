package com.example.queue;

/**
 * Create in 2018/4/10 22:36.
 *
 * @author lhh.
 * <p>优先级</p>
 */
public enum Priority {
    /**
     * 优先级最低
     */
    A,

    /**
     * 默认优先级
     */
    B,

    /**
     * 优先级最高
     */
    C,

    /**
     * 一般情况下不用；特殊情况下，请求假如到到队列后立即执行
     */
    D
}
