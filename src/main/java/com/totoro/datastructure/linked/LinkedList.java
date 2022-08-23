package com.totoro.datastructure.linked;

/**
 * @author:totoro
 * @createDate:2022/8/23
 * @description:
 */
public class LinkedList<E> implements List<E>{


    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public LinkedList(){}

    //添加头节点
    void linkFirst(E e){
        //拿到当前头节点
        final Node<E> f = first;
        //定义一个新节点，让尾指针指向当前头节点，头指针指向null
        final Node<E> newNode = new Node<>(null, e, f);
        //新节点变成头节点
        first = newNode;
        if (f == null){
            //如果当前头节点是空，那么尾节点也是新节点
            last = newNode;
        }else{
            //当前头节点不为空，让当前头节点头指针指向新节点
            f.prev = newNode;
        }
        //长度+1
        size++;
    }

    //添加尾节点
    void linkLast(E e){
        //获取当前尾节点
        final Node<E> l = last;
        //定义一个新节点，让头指针指向当前尾节点，尾指针指向null
        final Node<E> newNode = new Node<>(l,e,null);
        //新节点变成尾节点
        last = newNode;
        if ( l ==null ){
            //当前尾节点为空，那么头节点也是新节点
            first = newNode;
        } else {
            //让当前尾节点尾指针指向新节点
            l.next = newNode;
        }
        size++;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean addFirst(E e) {
        linkFirst(e);
        return true;
    }

    @Override
    public boolean addLast(E e) {
        linkLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        //移除所有空元素
        if ( null == o){
            for (Node<E> x = first; x != null; x=x.next){
                if (x.item == null){
                    unlink(x);
                    return true;
                }
            }
        } else {
            //移除对应的元素
            for ( Node<E> x = first; x != null; x = x.next){
                if (o.equals(x.item)){
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    //移除目标节点x
    E unlink(Node<E> x){
        //拿到要移除的节点元素
        final E element = x.item;
        //拿到目标节点x的后节点
        final Node<E> next = x.next;
        //拿到目标节点x的前节点
        final Node<E> prev = x.prev;

        if (prev == null) {
            //如果目标节点x的前节点为空，那么目标节点x的后节点为链表的头节点
            first = next;
        } else {
            //让目标节点x的前节点尾指针指向目标节点的后节点
            prev.next = next;
            //目标节点头指针指向空，断开和链表的连接
            x.prev = null;
        }

        if (next == null){
            //如果目标节点的后节点为空，说明目标节点是尾节点，让目标节点x的前节点成为新的尾节点
            last = prev;
        } else {
            //让目标节点x的后节点头指针指向目标节点x的前节点
            next.prev = prev;
            //目标节点尾指针指向空，断开和链表的连接
            x.next = null;
        }
        //目标节点元素为空，让垃圾回收器准备回收它
        x.item = null;
        //长度-1
        size--;
        //返回移除的元素
        return element;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    //获取节点对应元素
    Node<E> node(int index){
        //如果index小于size一半，从头节点开始遍历，减少操作， size>>1 = size/2
        if (index < (size >> 1)){
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        }else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    @Override
    public void printLinkList() {
        if (this.size == 0) {
            System.out.println("链表为空");
        } else {
            Node<E> temp = first;
            System.out.print("目前的列表，头节点：" + first.item + " 尾节点：" + last.item + " 整体：");
            while (temp != null) {
                System.out.print(temp.item + "，");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    //定义节点
    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next){
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
