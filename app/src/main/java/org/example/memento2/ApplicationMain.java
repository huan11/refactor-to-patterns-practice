package org.example.memento2;

import java.util.Scanner;

/**
 * 备忘录模式的客户端测试类
 * 实现了一个简单的文本编辑器，支持文本输入和撤销操作
 */
public class ApplicationMain {
  /**
   * 主方法，处理用户输入并展示文本编辑器的功能
   * 支持的命令：
   * - :list 显示当前文本内容
   * - :undo 撤销上一次输入
   * - 其他输入会被追加到文本内容中
   */
  public static void main(String[] args) {
    // Caretaker（管理 Snapshot）
    SnapshotHolder snapshotsHolder = new SnapshotHolder();
    // Originator
    InputText inputText = new InputText();
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNext()) {
      String input = scanner.next();
      if (input.equals(":list")) {
        System.out.println(inputText.getText());
      } else if (input.equals(":undo")) {
        // Use Originator to restore the state
        Snapshot snapshot = snapshotsHolder.popSnapshot();
        inputText.restoreSnapshot(snapshot);
      } else {
        // Use Originator to save the state
        snapshotsHolder.pushSnapshot(inputText.createSnapshot());
        inputText.append(input);
      }
    }
  }
}