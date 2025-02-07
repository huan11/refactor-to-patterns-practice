package org.example.memento2;

/**
 * Originator（发起人）角色
 * 记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能
 */
public class InputText {
    /**
     * 当前文本内容
     */
    private StringBuilder text = new StringBuilder();

    /**
     * 获取当前文本内容
     *
     * @return 返回当前文本内容的字符串形式
     */
    public String getText() {
        return text.toString();
    }

    /**
     * 追加输入的文本内容
     *
     * @param input 要追加的文本内容
     */
    public void append(String input) {
        text.append(input);
    }

    /**
     * 创建当前状态的备忘录
     *
     * @return 返回包含当前文本内容的Snapshot对象
     */
    public Snapshot createSnapshot() {
        return new Snapshot(text.toString());
    }

    /**
     * 根据备忘录恢复到之前的状态
     *
     * @param snapshot 包含之前状态的Snapshot对象
     */
    public void restoreSnapshot(Snapshot snapshot) {
        this.text.replace(0, this.text.length(), snapshot.getText());
    }
}




