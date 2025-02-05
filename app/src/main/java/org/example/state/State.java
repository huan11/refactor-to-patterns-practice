package org.example.state;

// 定义马里奥的状态枚举
// 小马里奥（Small Mario）、超级马里奥（Super Mario）、火焰马里奥（Fire Mario）、斗篷马里奥（Cape Mario）等等。
enum State {
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

// 马里奥状态机类
class MarioStateMachine {
    private int score;          // 当前分数
    private State currentState; // 当前状态

    // 构造函数，初始化为小状态和0分
    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    // 获得蘑菇
    public void obtainMushRoom() {
        if (currentState == State.SMALL) {
            this.currentState = State.SUPER;
            this.score += 100;
        }
    }

    public void obtainCape() {
        if (currentState == State.SMALL || currentState == State.SUPER) {
            this.currentState = State.CAPE;
            this.score += 200;
        }
    }

    public void obtainFireFlower() {
        if (currentState == State.SMALL || currentState == State.SUPER) {
            this.currentState = State.FIRE;
            this.score += 300;
        }
    }

    public void meetMonster() {
        if (currentState == State.SUPER) {
            this.currentState = State.SMALL;
            this.score -= 100;
        } else if (currentState == State.CAPE) {
            this.currentState = State.SMALL;
            this.score -= 200;
        } else if (currentState == State.FIRE) {
            this.currentState = State.SMALL;
            this.score -= 300;
        }
    }

    // 获取当前分数
    public int getScore() {
        return this.score;
    }

    // 获取当前状态
    public State getCurrentState() {
        return this.currentState;
    }
}

// 应用程序演示类
class ApplicationDemo {
    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom(); // 马里奥获得蘑菇
        int score = mario.getScore(); // 获取当前分数
        State state = mario.getCurrentState(); // 获取当前状态
        System.out.println("mario score: " + score + "; state: " + state);
    }
}