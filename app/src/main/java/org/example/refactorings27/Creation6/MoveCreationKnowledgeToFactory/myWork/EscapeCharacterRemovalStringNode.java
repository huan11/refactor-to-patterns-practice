package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.myWork;

// EscapeCharacterRemovalStringNode.java
public class EscapeCharacterRemovalStringNode extends StringNode {
    public EscapeCharacterRemovalStringNode(StringNode stringNode) {
        super(stringNode.getTextBuffer(), stringNode.getTextBegin(), stringNode.getTextEnd());
    }
}