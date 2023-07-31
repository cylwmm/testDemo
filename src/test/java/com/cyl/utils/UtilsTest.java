package com.cyl.utils;

import com.cyl.learn.domain.User;
import com.cyl.learn.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.Map;
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

    @Test
    public void testMapUtils() {
        User user = User.builder().id("12").age("12").name("11").build();
        Map<String, Object> userMap = MapUtils.objectToMap(user);
        System.out.println(userMap);
    }

}