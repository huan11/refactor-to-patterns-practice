package org.example;

import java.util.Calendar;

public class BuilderPatternExample {
    public static void main1(String[] args) {
        // Director 角色（客户端）负责调用 Builder 来构建 Calendar 对象
        Calendar calendar = new Calendar.Builder()
                .setDate(2025, 1, 4)  // 设置日期
                .setTimeOfDay(12, 30, 0) // 设置时间
                .build();  // 构建 Calendar 实例（Product）

        // 输出构建的 Calendar 对象
        System.out.println(calendar.getTime());
    }

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());

    }
}
