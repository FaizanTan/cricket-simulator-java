package com.practice.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class IdGenerator {
    private static final ConcurrentHashMap<String, AtomicLong> counters = new ConcurrentHashMap<>();

    public static long nextId(String context) {
        // Each context gets its own counter
        return counters
                .computeIfAbsent(context, k -> new AtomicLong())
                .incrementAndGet();
    }
}
