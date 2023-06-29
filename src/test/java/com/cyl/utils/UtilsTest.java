package com.cyl.utils;

import org.junit.jupiter.api.Test;

import java.util.Set;


class UtilsTest {
    @Test
    public void test1() {
        Set<Integer> integers = Utils.of(1, 2, 3, 1);
        int sum = 0;
        for (Integer a : integers) {
            sum+=a;
        }
        System.out.println(sum);
    }

}