package com.totoro.tree.balance;

import com.totoro.tree.Node;
import com.totoro.tree.order.Order;

/**
 * @author:totoro
 * @createDate:2022/11/4
 * @description:
 */
public class Test {
    public static void main(String[] args) {

        //创建原始平衡二叉树
        Node<Integer> a = new Node<>();
        Node<Integer> b = new Node<>();
        Node<Integer> c = new Node<>();
        Node<Integer> d = new Node<>();
        Node<Integer> e = new Node<>();
        a.setE(15);
        b.setE(13);
        c.setE(20);
        d.setE(11);
        e.setE(14);
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);




    }
}
