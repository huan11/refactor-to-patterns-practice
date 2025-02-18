package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.myWork;

// Client.java
public class Client {
    private Parser parser;

    public Client(Parser parser) {
        this.parser = parser;
    }

    public void setDecodeStringNodes(boolean shouldDecode) {
        parser.setDecodeStringNodes(shouldDecode);
    }

    public void parse(String url) {
        parser.parse(url);
    }
}