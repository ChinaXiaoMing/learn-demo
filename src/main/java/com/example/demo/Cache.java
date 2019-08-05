package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {

    private static Map<String, Object> cache = new HashMap<>();

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static Object get(String key) {
        lock.readLock().lock();
        try {
            return cache.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    public static Object put(String key, Object value) {
        lock.writeLock().lock();
        try {
            return cache.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void clear() {
        lock.writeLock().lock();
        try {
            cache.clear();
        } finally {
            lock.writeLock().unlock();
        }
    }

}
