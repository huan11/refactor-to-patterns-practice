之前的代码 不满足要在不违背封装原则的前提下，进行对象的备份和恢复。

思考：memento 文件夹为什么不满足呢？

## 原因1:

```java
public class InputText {
    private StringBuilder text = new StringBuilder();

    public void setText(String text) { // 不满足封装原则，原因: 暴露了内部状态
        this.text.replace(0, this.text.length(), text);
    }
}
```


```java
public class InputText {
    private StringBuilder text = new StringBuilder();
    
    /**
     * 根据备忘录恢复到之前的状态
     *
     * @param snapshot 包含之前状态的Snapshot对象
     */
    public void restoreSnapshot(Snapshot snapshot) {
        this.text.replace(0, this.text.length(), snapshot.getText());
    }
}
```


封装性讨论：
setText() 直接接受一个String参数，外部代码可以传入任意字符串来修改内部状态，这违反了封装原则
RestoreSnapshot() 只接受 Snapshot 类型的参数，这保证了文本的状态只能通过之前保存的快照来恢复，提供了更好的封装性




## 原因2:
快照本身是不可变的，理论上讲，不应该包含任何 set() 等修改内部状态的函数，但在上面的代码实现中，“快照“这个业务模型复用了 InputText 类的定义，而 InputText 类本身有一系列修改内部状态的函数，所以，用 InputText 类来表示快照违背了封装原则。

## 解决方法
其一，定义一个独立的类（Snapshot 类）来表示快照，而不是复用 InputText 类。这个类只暴露 get() 方法，没有 set() 等任何修改内部状态的方法。

其二，在 InputText 类中，我们把 setText() 方法重命名为 restoreSnapshot() 方法，用意更加明确，只用来恢复对象。


