package com.cyl.test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {

    public static void main(String[] args) {
        testConsumer();
        testSupplier();
        testPredict();
    }

    private static void testConsumer() {
        Consumer<String> consumer = System.out::println;
        Stream.of("a", "b").forEach(consumer);
    }

    private static void testSupplier() {
        Supplier<Double> supplier = () -> Math.random() * 100;
        System.out.println(supplier.get());
    }

    private static void testPredict() {
        Predicate<Integer> predicate = integer1 -> integer1 > 5;
        System.out.println(predicate.test(9));

        List<Integer> collect = Stream.of(2, 3, 5, 9).filter(predicate).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
