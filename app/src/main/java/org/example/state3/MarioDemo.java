package org.example.state3;

public class MarioDemo {
  public static void main(String[] args) {
    MarioStateMachine mario = new MarioStateMachine();
    
    System.out.println("初始状态：");
    printMarioState(mario);
    
    // 测试从小马里奥开始的状态转换
    System.out.println("\n1. 获得蘑菇：");
    mario.obtainMushRoom();
    printMarioState(mario);
    
    System.out.println("\n2. 获得斗篷：");
    mario.obtainCape();
    printMarioState(mario);
    
    System.out.println("\n3. 获得火花：");
    mario.obtainFireFlower();
    printMarioState(mario);
    
    System.out.println("\n4. 遇到怪物：");
    mario.meetMonster();
    printMarioState(mario);
    
    System.out.println("\n5. 直接获得火花：");
    mario.obtainFireFlower();
    printMarioState(mario);
    
    System.out.println("\n6. 获得斗篷：");
    mario.obtainCape();
    printMarioState(mario);
  }
  
  private static void printMarioState(MarioStateMachine mario) {
    System.out.println("当前状态：" + mario.getCurrentState().getValue());
    System.out.println("当前分数：" + mario.getScore());
  }
} 