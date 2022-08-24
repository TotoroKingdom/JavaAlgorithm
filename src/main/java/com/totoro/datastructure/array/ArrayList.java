package com.totoro.datastructure.array;

import java.util.Arrays;

/**
 * @author:totoro
 * @createDate:2022/8/23
 * @description:
 */
public class ArrayList<E> implements List<E> {
    //默认初始化空间大小
    private static final int DEFAULT_CAPACITY = 10;
    //空元素
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA={};
    //元素数组缓存区
    transient Object[] elementData;
    //集合元素数量
    private int size;

    public ArrayList(){
        // 默认给个空的元素，当开始添加元素的时候在初始化长度
        this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }

    @Override
    public boolean add(E e) {
        int minCapacity = size + 1;
        if (elementData == DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA){
            minCapacity = Math.min(DEFAULT_CAPACITY, minCapacity);
        }

        if (minCapacity - elementData.length > 0){
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0){
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    @Override
    public E get(int index) {

        return (E) elementData[index];
    }

    @Override
    public String toString(){
        return "ArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }
}
