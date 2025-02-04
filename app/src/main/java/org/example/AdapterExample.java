package org.example;

import java.util.Arrays;
import java.util.List;

public class AdapterExample {
    public static void main(String[] args) {
        // 原始数组（Adaptee）
        String[] array = {"A", "B", "C"};

        // 适配器：将数组适配为 List
        List<String> list = Arrays.asList(array);

        // 访问 List 的方法
        System.out.println(list.get(1));  // 输出: B

        // 但这个 List 仍然受限于数组的特性
        list.set(1, "X");  // 允许修改
        System.out.println(Arrays.toString(array)); // 输出: [A, X, C]

         list.add("D");  // ❌ 会抛出 UnsupportedOperationException
    }
}
