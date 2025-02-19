package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.myWork;

// Parser.java
public class Parser {
    private StringNodeParsingOption stringNodeParsingOption = new StringNodeParsingOption();
    private StringParser stringParser;

    public Parser() {
        this.stringParser = new StringParser(this);
    }

    public StringNodeParsingOption getStringNodeParsingOption() {
        return stringNodeParsingOption;
    }

    public void setStringNodeParsingOption(StringNodeParsingOption option) {
        stringNodeParsingOption = option;
    }

    public void parse(String url) {
        // 模拟解析过程
        StringBuffer textBuffer = new StringBuffer("Sample text &amp; content");
        Node node = stringParser.findString(textBuffer, 0, textBuffer.length());
        System.out.println("Node created: " + node.getClass().getSimpleName());
    }
}