package com.example.demo.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFilterTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(21, 22, 101, 102);
        Optional<Integer> reduce = list.stream().reduce(Integer::min);
        System.out.println(reduce.get());
    }

}
