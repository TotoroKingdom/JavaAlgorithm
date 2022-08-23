package com.totoro.datastructure.linked;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author:totoro
 * @createDate:2022/8/23
 * @description:
 */
@SpringBootTest
class LinkedListTest {



    @Test
    void test() {
        LinkedList<Object> nodeList = new LinkedList<>();
        nodeList.add("11");
        nodeList.add("22");
        nodeList.add("33");
        nodeList.add("aa");
        nodeList.add("bb");
        nodeList.printLinkList();
        nodeList.remove("22");
        nodeList.printLinkList();
        Object o = nodeList.get(1);
        System.out.println(o);

        nodeList.printLinkList();
        nodeList.unlink(nodeList.last);
        nodeList.printLinkList();

    }




}