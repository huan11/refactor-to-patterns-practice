package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.initialCode;

// DecodingStringNode.java
public class DecodingStringNode extends StringNode {
    public DecodingStringNode(StringNode stringNode) {
        super(stringNode.getTextBuffer(), stringNode.getTextBegin(), stringNode.getTextEnd());
    }
}