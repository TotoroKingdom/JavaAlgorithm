package com.totoro.datastructure.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author:totoro
 * @createDate:2022/8/24
 * @description:
 */
@Slf4j
public class PriorityQueue<E> implements Queue<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    transient Object[] queue;
    private int size = 0;

    public PriorityQueue(){
        queue = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public boolean offer(E e){
        if (e == null){
            throw new NullPointerException();
        }
        int i = size;
        if (i >= queue.length){
            grow(i + 1);
        }
        size = i + 1;
        if (i == 0){
            queue[0] = e;
        } else {
            siftUP(i, e);
        }
        return true;
    }

    private void grow(int minCapacity){
        int oldCapacity = queue.length;
        int newCapacity = oldCapacity + ((oldCapacity < 64)? (oldCapacity + 2):(oldCapacity >> 1));
        if (newCapacity - Integer.MAX_VALUE - 8 > 0){
            newCapacity = (minCapacity > Integer.MAX_VALUE - 8) ?
                    Integer.MAX_VALUE :
                    Integer.MAX_VALUE - 8;
        }
        queue = Arrays.copyOf(queue, newCapacity);
    }

    private void siftUP(int k, E x) {
        siftUpComparable(k, x);
    }

    private void siftUpComparable(int k, E x){
        Comparable<? super E> key = (Comparable<? super E>) x;
        log.info("【入队】元素：{} 当前队列：{}", key , queue);
        while (k > 0){
            int parent = (k - 1) >>> 1;
            log.info("【入队】寻找当前节点的父节点位置。k：{} parent：{}", k, parent);
            Object e = queue[parent];
            if (key.compareTo((E) e) >= 0){
                log.info("【入队】值比对，父节点：{} 目标节点：{}", e , key);
                break;
            }
            log.info("【入队】替换过程，父子节点位置替换，继续循环。父节点值：{} 存放到位置：{}", e, k);
            queue[k] = e;
            k = parent;
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
        log.info("【入队】完成 Idx：{} Val：{} \r\n当前队列：{} \r\n", k, key, queue);

    }

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public E poll() {
        if (size == 0){
            return null;
        }
        int s = --size;
        E result = (E) queue[0];
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0){
            siftDown(0,x);
        }
        return result;
    }

    private void siftDown(int k, E x){
        siftDownComparable(k,x);
    }

    private void siftDownComparable(int k, E x){
        Comparable<? super E> key = (Comparable<? super E>) x;

        int half = size >>> 1;

        while (k < half){
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;

            if (right < size && ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0){
                log.info("【出队】左右子节点比对，获取最小值。left：{} right：{}", c, queue[right]);
                c = queue[child = right];
            }
            if (key.compareTo((E) c) <= 0){
                break;
            }

            log.info("【出队】替换过程，节点的值比对。上节点：{} 下节点：{} 位置替换", queue[k], c);
            queue[k] = c;
            k = child;
        }
        log.info("【出队】替换结果，最终更换位置。Idx：{} Val：{}", k, key);
        queue[k] = key;
    }

    @Override
    public E peek() {
        return (size == 0) ? null: (E) queue[0];
    }
}
