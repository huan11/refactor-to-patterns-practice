package org.example.memento2;

/**
 * Memento（备忘录）角色
 * 负责存储Originator对象的内部状态，在需要的时候提供这些内部状态给Originator对象
 */
public class Snapshot {
  /**
   * 用于存储文本内容的状态
   */
  private String text;

  /**
   * 构造函数，接收要保存的文本内容
   * @param text 要保存的文本内容
   */
  public Snapshot(String text) {
    this.text = text;
  }

  /**
   * 获取保存的文本内容
   * @return 返回保存的文本内容
   */
  public String getText() {
    return this.text;
  }
}