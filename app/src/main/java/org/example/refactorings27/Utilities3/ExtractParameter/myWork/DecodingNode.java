package org.example.refactorings27.Utilities3.ExtractParameter.myWork;


import org.checkerframework.checker.units.qual.N;

public class DecodingNode implements Node {
    private Node delegate;

    public DecodingNode(StringBuffer textBuffer, int textBegin, int textEnd, Node newDelegate) {
//        delegate = new StringNode(textBuffer, textBegin, textEnd);
        delegate = newDelegate;
    }

    // Remove Parameter
    public DecodingNode(Node newDelegate) {
        delegate = newDelegate;
    }
    @Override
    public void someMethod() {}
}
