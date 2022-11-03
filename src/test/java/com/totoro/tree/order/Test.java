package com.totoro.tree.order;

import com.totoro.tree.Node;

/**
 * @author:totoro
 * @createDate:2022/11/3
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Node<String> a = new Node<String>();
        Node<String> b = new Node<String>();
        Node<String> c = new Node<String>();
        Node<String> d = new Node<String>();
        Node<String> e = new Node<String>();
        Node<String> f = new Node<String>();

        a.setE("A");
        b.setE("B");
        c.setE("C");
        d.setE("D");
        e.setE("E");
        f.setE("F");

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);

        System.out.println("//前序遍历  预期输出 A B D E C F");
        Order.preOrder(a);

        System.out.println();
        System.out.println("//中序遍历  预期输出 D B E A C F");
        Order.midOrder(a);

        System.out.println();
        System.out.println("//后序遍历 预期输出  D E B F C A");
        Order.postOrder(a);
    }
}
