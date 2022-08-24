package com.totoro.datastructure.stack;

import lombok.extern.slf4j.Slf4j;

/**
 * @author:totoro
 * @createDate:2022/8/24
 * @description:
 */
@Slf4j
public class ArrayDeque<E> implements Deque<E> {

    /**
     * 存储双端队列元素的数组。双端队列的容量就是这个数组的长度，它总是 2 的幂。
     * 数组永远不允许变满，除非在 addX 方法中短暂地在变满后立即调整大小（请参阅 doubleCapacity），
     * 从而避免头部和尾部环绕以彼此相等。我们还保证所有不包含双端队列元素的数组单元始终为空。
     */
    transient Object[] elements;
    //双端队列头部元素的索引（将被 remove() 或 pop() 删除的元素）；如果双端队列为空，则为等于 tail 的任意数字。
    transient int head;
    //将下一个元素添加到双端队列尾部的索引（通过 addLast(E)、add(E) 或 push(E)）
    transient int tail;

    public ArrayDeque(){
        elements = new Object[2];
    }

    private void doubleCapacity(){
        assert head == tail;
        int p = head;
        int n = elements.length;
        int r = n - p;
        int newCapacity = n << 1;
        if (newCapacity < 0){
            throw new IllegalStateException("Sorry, deque too big");
        }
        Object[] a = new Object[newCapacity];
        System.arraycopy(elements,p,a,0,r);
        System.arraycopy(elements,0,a,r,p);
        elements = a;
        head = 0;
        tail = n;
    }



    @Override
    public void push(E e) {

        if (e == null){
            throw new NullPointerException();
        }
        elements[head = (head - 1) & (elements.length - 1)] = e;
        log.info("push.idx head:{}",head);
        if (head == tail){
            doubleCapacity();
        }

    }

    @Override
    public E pop() {

        int h = head;
        E result = (E) elements[h];
        if (result == null){
            return null;
        }
        elements[h] = null;
        head = (h+1) & (elements.length - 1);
        log.info("pop.idx{}={}&{}",head,Integer.toBinaryString(h+1),Integer.toBinaryString(elements.length - 1));
        return result;
    }
}
