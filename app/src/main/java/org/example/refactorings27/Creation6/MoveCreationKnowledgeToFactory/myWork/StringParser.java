package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.myWork;

// StringParser.java
public class StringParser {
    private Parser parser;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node findString(StringBuffer textBuffer, int textBegin, int textEnd) {
        boolean shouldDecode = parser.shouldDecodeStringNodes();
        // 创建 StringNode 实例
        return StringNode.createStringNode(textBuffer, textBegin, textEnd, shouldDecode);
    }
}