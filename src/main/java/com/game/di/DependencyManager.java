package com.game.di;

import java.util.HashMap;
import java.util.Map;

public class DependencyManager {

    private static final Map<String, Object> deps = new HashMap<>();

    private DependencyManager() {}

    public static <T> T get(String key) {
        return (T) deps.get(key);
    }

    public static void set(String key, Object instance) {
        deps.putIfAbsent(key, instance);
    }

}
