package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.myWork;

public class StringNodeParsingOption {
    public boolean shouldDecodeStringNodes = false;

    public StringNodeParsingOption() {
    }

    public void setDecodeStringNodes(boolean shouldDecode) {
        this.shouldDecodeStringNodes = shouldDecode;
    }

    public boolean shouldDecodeStringNodes() {
        return shouldDecodeStringNodes;
    }
}