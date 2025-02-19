package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.myWork;

// StringParser.java
public class StringParser {
    private Parser parser;

    public StringParser(Parser parser) {
        this.parser = parser;
    }

    public Node findString(StringBuffer textBuffer, int textBegin, int textEnd) {
//        NodeFactory nodeFactory = new NodeFactory();
//        return nodeFactory.createStringNode(textBuffer, textBegin, textEnd, parser.getStringNodeParsingOption().shouldDecodeStringNodes());

        // Step 2 route the call of creation method to middle class
        return parser.getNodeFactory().createStringNode(textBuffer, textBegin, textEnd);

    }
}