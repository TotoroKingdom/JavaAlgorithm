package com.totoro.datastructure.queue;

/**
 * @author:totoro
 * @createDate:2022/8/24
 * @description:
 */
public interface Queue<E> {

    boolean add(E e);

    boolean offer(E e);

    E poll();

    E peek();
}
