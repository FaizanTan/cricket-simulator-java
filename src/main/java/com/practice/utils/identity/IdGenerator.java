package com.practice.utils.identity;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.random.RandomGenerator;

public final class IdGenerator {
    private static final ConcurrentHashMap<String, AtomicLong> counters = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, AtomicLong> getCounters() {
        return counters;
    }

    public static long generateIdFor(String context) {
        return counters
                .computeIfAbsent(context, k -> new AtomicLong())
                .incrementAndGet();
    }

    public static <T> T generateRandomIdOfType(Class<T> type) {
        RandomGenerator random = RandomGenerator.getDefault();

        if (type == Integer.class) {
            return type.cast(random.nextInt());
        } else if (type == Long.class) {
            return type.cast(random.nextLong());
        } else if (type == String.class) {
            return type.cast(UUID.randomUUID().toString());
        }

        throw new IllegalArgumentException("Unsupported type: " + type.getName());
    }
}
