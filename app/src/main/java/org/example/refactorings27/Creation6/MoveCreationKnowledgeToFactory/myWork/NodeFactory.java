package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.myWork;

public class NodeFactory {
    public boolean shouldDecodeStringNodes = false;

    public NodeFactory() {
    }

    public void setDecodeStringNodes(boolean shouldDecode) {
        this.shouldDecodeStringNodes = shouldDecode;
    }

    public boolean shouldDecodeStringNodes() {
        return shouldDecodeStringNodes;
    }

    // Step 1 Move the Factory creation method to middle class
    public Node createStringNode(StringBuffer textBuffer, int textBegin, int textEnd) {
        if (shouldDecodeStringNodes) {
            return new DecodingStringNode(new StringNode(textBuffer, textBegin, textEnd));
        }
        return new StringNode(textBuffer, textBegin, textEnd);
    }
}