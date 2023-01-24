package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class WithIndex {
    public static <T, R> Function<T, R> apply(int start, BiIntFunction<T, R> function) {
        AtomicInteger counter = new AtomicInteger(start);
        return object -> function.apply(object, counter.getAndAdd(1));
    }
}