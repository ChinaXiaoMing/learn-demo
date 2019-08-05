package com.example.demo.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamTest {

    private static int total = 100_000_000;

    public static void main(String[] args) {
        System.out.println(String.format("本计算机CPU逻辑核数：%d", Runtime.getRuntime().availableProcessors()));
        Random random = new Random();
        List<Integer> list = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {
            list.add(random.nextInt(100));
        }
        long start = System.currentTimeMillis();
        list.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println(String.format("单线程计算耗时：%d", System.currentTimeMillis() - start));
        long start1 = System.currentTimeMillis();
        list.stream().parallel().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println(String.format("多线程计算耗时：%d", System.currentTimeMillis() - start1));
    }

}
