package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.myWork;

// StringParser.java
public class StringParser {
    private Parser parser;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node findString(StringBuffer textBuffer, int textBegin, int textEnd) {
        // 创建 StringNode 实例
        NodeFactory nodeFactory = new NodeFactory();
        return nodeFactory.createStringNode(textBuffer, textBegin, textEnd, parser.getStringNodeParsingOption().shouldDecodeStringNodes());
    }
}