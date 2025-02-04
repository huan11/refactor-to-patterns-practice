package org.example;

public enum Logger {
    // 一个枚举类型只能有固定的几个实例（即枚举常量）
    USER_LOGGER("User.class"),
    ORDER_LOGGER("Order.class");

    private final String loggerName;

    // 枚举构造函数
    Logger(String loggerName) {
        this.loggerName = loggerName;
    }

    public void log(String message) {
        System.out.println("[" + loggerName + "] " + message);
    }


    public static void main(String[] args) {
        Logger l1 = Logger.USER_LOGGER;
        Logger l2 = Logger.USER_LOGGER;
        Logger l3 = Logger.ORDER_LOGGER;

        // 验证 l1 == l2
        System.out.println("l1 == l2: " + (l1 == l2)); // 输出: true

        // 验证 l1 != l3
        System.out.println("l1 != l3: " + (l1 != l3)); // 输出: true

        // 使用日志功能
        l1.log("This is a user log."); // 输出: [User.class] This is a user log.
        l3.log("This is an order log."); // 输出: [Order.class] This is an order log.
    }

}