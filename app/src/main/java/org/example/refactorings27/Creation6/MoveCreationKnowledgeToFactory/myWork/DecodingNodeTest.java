package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.myWork;

public class DecodingNodeTest {
    private Parser parser;

    public void testDecodeAmpersand(){
         // parser.setDecodeStringNodes(true);
        StringNodeParsingOption decodeNodes = new StringNodeParsingOption();
        decodeNodes.setDecodeStringNodes(true);
        parser.setStringNodeParsingOption(decodeNodes);
    }
}
