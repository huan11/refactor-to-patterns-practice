package org.example.memento2;

import java.util.Stack;

/**
 * Caretaker（管理者）角色
 * 负责保存备忘录对象，但不能对备忘录对象的内容进行操作或检查
 */
public class SnapshotHolder {
  /**
   * 使用栈结构存储备忘录对象，支持后进先出的操作方式
   */
  private Stack<Snapshot> snapshots = new Stack<>();

  /**
   * 取出最近一次保存的备忘录对象
   * @return 返回最近保存的Snapshot对象
   */
  public Snapshot popSnapshot() {
    return snapshots.pop();
  }

  /**
   * 存入一个新的备忘录对象
   * @param snapshot 要保存的Snapshot对象
   */
  public void pushSnapshot(Snapshot snapshot) {
    snapshots.push(snapshot);
  }
}
