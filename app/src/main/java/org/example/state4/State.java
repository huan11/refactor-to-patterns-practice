package org.example.state4;

public enum State {
    SMALL(0),   // 小状态
    SUPER(1),   // 超级状态
    FIRE(2),    // 火焰状态
    CAPE(3);    // 斗篷状态

    private int value;

    // 构造函数
    private State(int value) {
        this.value = value;
    }

    // 获取状态值
    public int getValue() {
        return this.value;
    }
}