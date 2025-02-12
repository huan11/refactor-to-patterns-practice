package org.example.refactorings27.Utilities3.ExtractParameter.initialCode;

// StringNode 实现 Node 接口
public class StringNode implements Node {
    private StringBuffer textBuffer;
    private int textBegin;
    private int textEnd;

    public StringNode(StringBuffer textBuffer, int textBegin, int textEnd) {
        this.textBuffer = textBuffer;
        this.textBegin = textBegin;
        this.textEnd = textEnd;
    }

    @Override
    public void someMethod() {}
    
    public Node decode() {
        return new DecodingNode(textBuffer, textBegin, textEnd);
    }
}