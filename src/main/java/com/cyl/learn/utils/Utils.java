package com.cyl.learn.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Utils {
    @SafeVarargs
    public static <T> Set<T> of(T...a) {
        return Arrays.stream(a).peek(new HashSet<>()::add).collect(Collectors.toSet());
    }
}
