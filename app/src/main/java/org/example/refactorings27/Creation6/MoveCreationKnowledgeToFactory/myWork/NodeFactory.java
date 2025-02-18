package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.myWork;

public class NodeFactory {
    public Node createStringNode(StringBuffer textBuffer, int textBegin, int textEnd, boolean shouldDecode) {
        if (shouldDecode) {
            return new DecodingStringNode(new StringNode(textBuffer, textBegin, textEnd));
        }
        return new StringNode(textBuffer, textBegin, textEnd);
    }
}
