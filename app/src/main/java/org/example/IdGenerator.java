package org.example;

import java.util.concurrent.atomic.AtomicLong;

public enum IdGenerator {
    INSTANCE; // 单例实例

    private AtomicLong id = new AtomicLong(0); // 线程安全的 ID 生成器

    // 获取唯一 ID
    public long getId() {
        return id.incrementAndGet(); // 原子操作，线程安全
    }
}

class Main {
    public static void main(String[] args) {
        // 获取单例实例
        IdGenerator generator = IdGenerator.INSTANCE;

        // 生成唯一 ID
        System.out.println("ID 1: " + generator.getId()); // 输出: ID 1: 1
        System.out.println("ID 2: " + generator.getId()); // 输出: ID 2: 2
        System.out.println("ID 3: " + generator.getId()); // 输出: ID 3: 3

        // 验证单例性
        IdGenerator anotherGenerator = IdGenerator.INSTANCE;
        System.out.println("ID 4: " + anotherGenerator.getId()); // 输出: ID 4: 4
        System.out.println("generator == anotherGenerator: " + (generator == anotherGenerator)); // 输出: true
    }
}