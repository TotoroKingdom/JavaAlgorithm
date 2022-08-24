package com.totoro.datastructure.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author:totoro
 * @createDate:2022/8/24
 * @description:
 */
@SpringBootTest
class ArrayListTest {

    @Test
    void test(){
        ArrayList<Object> list = new ArrayList<>();
        list.add("01");
        list.add("02");
        list.add("03");
        list.add("04");
        list.add("05");
        list.add("06");
        list.add("07");
        list.add("08");
        list.add("09");
        list.add("10");
        list.add("11");
        list.add("12");
        System.out.println(list);
        list.remove(9);
        System.out.println(list);
    }

}