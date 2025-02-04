package org.example;

import org.example.MyModel;
import java.beans.PropertyChangeListener;

public class MyModelDemo {
  public static void main(String[] args) {
    // 1. 创建 MyModel 实例
    MyModel model = new MyModel("张三", 25);
    
    // 2. 添加属性变化监听器
    PropertyChangeListener listener = evt -> {
      System.out.println("属性 '" + evt.getPropertyName() + "' 发生变化:");
      System.out.println("原值: " + evt.getOldValue());
      System.out.println("新值: " + evt.getNewValue());
      System.out.println("------------------------");
    };
    
    // 注册监听器
    model.addPropertyChangeListener(listener);
    
    // 3. 获取初始属性值
    System.out.println("初始值:");
    System.out.println("姓名: " + model.GetName());
    System.out.println("年龄: " + model.GetAge());
    System.out.println("------------------------");
    
    // 4. 修改属性值 - 这将触发监听器
    System.out.println("开始修改属性:");
    model.SetName("李四");  // 这会触发监听器
    model.SetAge(30);      // 这也会触发监听器
    
    // 5. 打印最终结果
    System.out.println("最终值:");
    System.out.println("姓名: " + model.GetName());
    System.out.println("年龄: " + model.GetAge());
  }
} 