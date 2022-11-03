package com.totoro.tree.create;

import com.totoro.tree.Node;

/**
 * @author:totoro
 * @createDate:2022/11/3
 * @description:
 */
public class Test1 {
    public static void main(String[] args) {

        Node<String> a = new Node<>();
        Node<String> b = new Node<>();
        Node<String> c = new Node<>();
        Node<String> d = new Node<>();
        Node<String> e = new Node<>();

        a.setE("A");
        b.setE("B");
        c.setE("C");
        d.setE("D");
        e.setE("E");

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);

        System.out.println(a);


    }
}
