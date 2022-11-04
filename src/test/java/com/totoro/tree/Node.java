package com.totoro.tree;

import lombok.Data;
import org.springframework.util.ObjectUtils;

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

    Integer height = 1; //当前节点高度  用来计算平衡因子
}
