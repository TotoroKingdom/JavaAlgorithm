package com.totoro.tree.order;

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


}
