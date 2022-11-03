package com.totoro.tree;

import lombok.Data;

/**
 * @author:totoro
 * @createDate:2022/11/3
 * @description:
 */
@Data
public class Node<E> {

    E e; //元素
    Node left; //左儿子
    Node right; //右儿子

}
