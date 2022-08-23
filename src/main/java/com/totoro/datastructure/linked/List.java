package com.totoro.datastructure.linked;

/**
 * @author:totoro
 * @createDate:2022/8/23
 * @description:
 */
public interface List<E> {

    /**
     * 添加节点 == addLast
     * @param e
     * @return
     */
    boolean add(E e);

    /**
     * 在头节点添加节点
     * @param e
     * @return
     */
    boolean addFirst(E e);

    /**
     * 在尾节点添加节点
     * @param e
     * @return
     */
    boolean addLast(E e);

    /**
     * 移除节点
     * @param o
     * @return
     */
    boolean remove(Object o);

    /**
     * 获取节点元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 打印链表
     */
    void printLinkList();
}
