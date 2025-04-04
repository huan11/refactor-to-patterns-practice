package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.initialCode;

import lombok.Data;

// StringNode.java
@Data
public class StringNode implements Node {
    private StringBuffer textBuffer;
    private int textBegin;
    private int textEnd;

    public StringNode(StringBuffer textBuffer, int textBegin, int textEnd) {
        this.textBuffer = textBuffer;
        this.textBegin = textBegin;
        this.textEnd = textEnd;
    }

    public static Node createStringNode(StringBuffer textBuffer, int textBegin, int textEnd, boolean shouldDecode) {
        if (shouldDecode) {
            return new DecodingStringNode(new StringNode(textBuffer, textBegin, textEnd));
        }
        return new StringNode(textBuffer, textBegin, textEnd);
    }
}