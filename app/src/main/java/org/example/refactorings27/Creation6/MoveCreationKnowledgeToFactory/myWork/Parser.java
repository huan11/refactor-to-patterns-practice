package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.myWork;

// Parser.java
public class Parser {
    private StringParser stringParser;

    public Parser() {
        this.stringParser = new StringParser(this);
    }

    private boolean shouldDecodeStringNodes = false;

    public void setDecodeStringNodes(boolean shouldDecode) {
        this.shouldDecodeStringNodes = shouldDecode;
    }

    public boolean shouldDecodeStringNodes() {
        return shouldDecodeStringNodes;
    }

    public void parse(String url) {
        // 模拟解析过程
        StringBuffer textBuffer = new StringBuffer("Sample text &amp; content");
        Node node = stringParser.findString(textBuffer, 0, textBuffer.length());
        System.out.println("Node created: " + node.getClass().getSimpleName());
    }
}