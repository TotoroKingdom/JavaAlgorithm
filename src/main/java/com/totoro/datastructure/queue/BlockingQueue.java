package com.totoro.datastructure.queue;

/**
 * @author:totoro
 * @createDate:2022/8/24
 * @description:
 */
public interface BlockingQueue<E> extends Queue<E> {
    boolean add(E e);

    boolean offer(E e);
}
