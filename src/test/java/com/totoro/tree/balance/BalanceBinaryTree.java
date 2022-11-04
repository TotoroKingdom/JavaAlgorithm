package com.totoro.tree.balance;

import com.totoro.tree.Node;
import org.springframework.util.ObjectUtils;

/**
 * @author:totoro
 * @createDate:2022/11/4
 * @description:
 */
public class BalanceBinaryTree {

    static Integer max(Integer a, Integer b){
        return a > b ? a : b;
    }

    static Integer getHeight(Node node){
        if (ObjectUtils.isEmpty(node)){
            return 0;
        }
        return node.getHeight();
    }

    /**
     * 左旋操作，将根节点旋转到左边,将右边节点变为根节点
     */
    static Node leftRotation(Node root){
        Node newRoot = root.getRight(); //获取右边节点做为新的根节点
        root.setRight(newRoot.getLeft()); //将新根节点左儿子给旧根节点做右儿子
        newRoot.setLeft(root); //旧的根节点成为新的根节点的左儿子
        //计算高度
        root.setHeight(max(getHeight(root.getRight()), getHeight(root.getLeft())  + 1));
        newRoot.setHeight(max(getHeight(newRoot.getRight()),getHeight(newRoot.getLeft())) +1 );
        return newRoot;
    }

    /**
     * 右旋操作， 将根节点旋转到右边，将左节点变为根节点
     */
    static Node rightRotation(Node root){
        //1-获取左节点成为新的根节点
        Node newRoot = root.getLeft();
        //2-将新节点的右节点送给旧根节点的左节点
        root.setLeft(newRoot.getRight());
        //3-旧根节点成为新根节点的右节点
        newRoot.setRight(root);
        //计算高度
        root.setHeight(max(getHeight(root.getRight()), getHeight(root.getLeft())  + 1));
        newRoot.setHeight(max(getHeight(newRoot.getRight()),getHeight(newRoot.getLeft())) +1 );
        return newRoot;
    }

    /**
     * 左右旋  LR
     * @param root
     * @return
     */
    static Node leftRightRotation(Node root){
        //1-让根节点左节点左旋
        Node newLeft = leftRotation(root.getLeft());
        //2-让新的左旋节点成为根节点的左节点
        root.setLeft(newLeft);
        //3-让根节点右旋
        return rightRotation(root);

    }

    /**
     * 右左旋 RL
     * @param root
     * @return
     */
    static Node rightLeftRotation(Node root){
        //1-让根节点右节点右旋
        Node newRight = rightRotation(root.getRight());
        //2-让新的右旋节点成为根节点的右节点
        root.setRight(newRight);
        //3-让根节点左旋
        return leftRotation(root);

    }


    /**
     * 平衡二叉树
     * 1-平衡二叉树是二叉搜索树
     * 2-子节点也是平衡二叉树
     * 3-从根节点开始，左右子树高度不超过1
     */
    static Node insert(Node root, Integer i) {
        //1-如果根节点为空，则创建一个
        if (root == null) {
            root = new Node();
        } else if ((Integer) root.getE() > i) {
            //如果插入元素小于目标元素，插入左边
            Node leftNode = insert(root.getLeft(), i);
            root.setLeft(leftNode);
            //计算平衡因子
            if (getHeight(root.getLeft()) - getHeight(root.getRight()) > 1) { //如果插入到左边的高度大于右边的高度，需要旋转
                //判断需要旋转的类型是LL还是LR
                if ((Integer) root.getLeft().getE() > i) {
                    //插入在左边，LL旋转
                    root = leftRotation(root);
                } else {
                    //插入在右边，LR旋转
                    root = leftRightRotation(root);
                }

            } else if ((Integer) root.getE() < i) {
                //1-如果插入元素大于于当前元素，放右边，递归调用
                Node rightNode = insert(root.getRight(), i);
                root.setRight(rightNode);
                //计算平衡因子
                if (getHeight(root.getRight()) - getHeight(root.getLeft()) > 1) {
                    //判断需要旋转的类型是LL还是LR
                    if ((Integer) root.getRight().getE() > i) {
                        //插入在左边，RL旋转
                        root = rightLeftRotation(root);
                    } else {
                        //插入在右边，RR旋转
                        root = rightRotation(root);
                    }
                }
            }
        }
        //更新树的高度
        root.setHeight(max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1);
        return root;
    }




}
