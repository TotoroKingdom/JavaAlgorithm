package com.totoro.tree.balance;

import com.totoro.tree.Node;
import org.springframework.util.ObjectUtils;

/**
 * @author:totoro
 * @createDate:2022/11/3
 * @description:
 */
public class Order {

    //前序遍历 根左右
    static void preOrder(Node root){
        if (ObjectUtils.isEmpty(root)){
            return;
        }
        //1-打印根节点
        System.out.print(root.getE()+" ");
        //2-递归调用左节点
        preOrder(root.getLeft());
        //3-递归调用右节点
        preOrder(root.getRight());

    }

    //中序遍历 左根右
    static void midOrder(Node root){
        if (ObjectUtils.isEmpty(root)){
            return;
        }
        //1-递归调用左节点
        midOrder(root.getLeft());
        //2-打印根节点
        System.out.print(root.getE()+" ");
        //3-递归调用右节点
        midOrder(root.getRight());

    }

    //后序遍历  左右根
    static void postOrder(Node root){

        if (ObjectUtils.isEmpty(root)){
            return;
        }
        //1-递归左节点
        postOrder(root.getLeft());
        //2-递归右节点
        postOrder(root.getRight());
        //3-打印
        System.out.print(root.getE()+" ");
    }

    /**
     * 二叉搜索树  左儿子小于根节点 右节点大于根节点
     * @param node
     * @param e
     * @return
     */
    static Node binarySearchTree(Node node, Integer e){
        if(ObjectUtils.isEmpty(node)){
            //如果是空的，插入一个根节点
            Node<Integer> n = new Node<>();
            n.setE(e);
            return n;
        }else{

            if ((Integer) e > (Integer) node.getE()){
                //1-如果插入元素大于当前元素，放右边，递归调用
                Node rightNode = binarySearchTree(node.getRight(), e);
                node.setRight(rightNode);
            }else if ((Integer) e < (Integer) node.getE()){
                //2-如果插入元素小于当前元素，放左边，递归调用
                Node leftNode = binarySearchTree(node.getLeft(), e);
                node.setLeft(leftNode);
            }
            return node;
        }
    }



}
