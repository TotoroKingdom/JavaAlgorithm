package com.totoro.tree.order;

import com.totoro.tree.Node;

/**
 * @author:totoro
 * @createDate:2022/11/3
 * @description:
 */
public class TestBinarySearchTree {
    public static void main(String[] args) {

        //11 35 98 67 12 36
        Node root = Order.binarySearchTree(null, 11);
        Order.binarySearchTree(root,35);
        Order.binarySearchTree(root,98);
        Order.binarySearchTree(root,67);
        Order.binarySearchTree(root,12);
        Order.binarySearchTree(root,36);

        Order.midOrder(root);

    }
}
