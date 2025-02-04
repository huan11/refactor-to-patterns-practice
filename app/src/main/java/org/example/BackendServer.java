package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BackendServer {
    private long serverNo;
    private String serverAddress;

    private static final int SERVER_COUNT = 3;
    private static final Map<Long, BackendServer> serverInstances = new HashMap<>();

    // 静态代码块初始化服务器实例
    static {
        serverInstances.put(1L, new BackendServer(1L, "192.134.22.138:8080"));
        serverInstances.put(2L, new BackendServer(2L, "192.134.22.139:8080"));
        serverInstances.put(3L, new BackendServer(3L, "192.134.22.140:8080"));
    }

    // 私有构造函数，防止外部直接创建实例
    private BackendServer(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    // 根据 serverNo 获取服务器实例
    public static BackendServer getInstance(long serverNo) {
        return serverInstances.get(serverNo);
    }

    // 随机获取一个服务器实例
    public static BackendServer getRandomInstance() {
        Random r = new Random();
        int no = r.nextInt(SERVER_COUNT) + 1; // 生成 1~3 的随机数
        return serverInstances.get((long) no);
    }

    // 模拟调用后端服务器
    public void call() {
        System.out.println("Calling backend server: " + this.serverAddress);
    }

    // 主方法，测试代码
    public static void main(String[] args) {
        // 1. 获取指定编号的服务器实例
        BackendServer server1 = BackendServer.getInstance(1L);
        if (server1 != null) {
            server1.call(); // 调用服务器
        } else {
            System.out.println("Server 1 not found!");
        }

        // 2. 获取随机服务器实例
        BackendServer randomServer = BackendServer.getRandomInstance();
        if (randomServer != null) {
            randomServer.call(); // 调用随机服务器
        } else {
            System.out.println("Random server not found!");
        }

        // 3. 测试不存在的服务器编号
        BackendServer invalidServer = BackendServer.getInstance(4L);
        if (invalidServer != null) {
            invalidServer.call();
        } else {
            System.out.println("Invalid server not found!"); // 输出：Invalid server not found!
        }
    }
}