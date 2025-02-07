package org.example.memento;

import java.util.Scanner;
import java.util.Stack;

public class InputText {
  private StringBuilder text = new StringBuilder();

  public String getText() {
    return text.toString();
  }

  public void append(String input) {
    text.append(input);
  }

  public void setText(String text) { // 不满足封装原则，原因: 暴露了内部状态
    this.text.replace(0, this.text.length(), text);
  }
}


