# Hollywood Principle: Do not call us, we will call you （Inversion of Control, IoC）

## 编程的术语的大白话解释（费曼）

1. 依赖注入: 你不需要创建对象，我们（框架）会帮你创建对象（依赖注入），你直接声明使用就可以了
2. 模版：你不需要定义程序的完整执行流程，我们（框架）已经帮你组织好了流程（模板方法），你实现你关心的某个环节就可以了
3. 回调：你不需要调用我们的方法，我们会在某个时机调用你的方法（回调），你只需要实现我们规定的接口就可以了

## 如何实现

1. 依赖注入：通过构造函数、属性、方法参数等方式，将依赖的对象传递给被依赖的对象
2. 模版：通过继承，重写父类的某些方法，来实现自己的逻辑
3. 回调：在 Java 中如何实现？ Java 中没有 C 语言里面的函数指针, 只能通过包裹了回调函数的类对象进行传递（简称回调对象）
感慨: 里氏替换原则真的是了不起：面向接口（接口是行为的抽象编程）

## 代码解释
### 回调示意代码
```java
public interface ICallback {
  void methodToCallback();
}

public class BClass {
  public void process(ICallback callback) {
    //...
    callback.methodToCallback();
    //...
  }
}

public class AClass {
  public static void main(String[] args) {
    BClass b = new BClass();
    b.process(new ICallback() { //回调对象
      @Override
      public void methodToCallback() {
        System.out.println("Call back me.");
      }
    });
  }
}
```
