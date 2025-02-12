package org.example.refactorings27.Utilities3.ExtractParameter.initialCode;


public class DecodingNode implements Node {
    private Node delegate;

    public DecodingNode(StringBuffer textBuffer, int textBegin, int textEnd) {
        delegate = new StringNode(textBuffer, textBegin, textEnd);
    }

    @Override
    public void someMethod() {}
}
