package org.example.refactorings27.Creation6.MoveCreationKnowledgeToFactory.myWork;

public class DecodingNodeTest {
    private Parser parser;

    public void testDecodeAmpersand(){
         // parser.setDecodeStringNodes(true);
        NodeFactory decodeNodes = new NodeFactory();
        decodeNodes.setDecodeStringNodes(true);
        parser.setNodeFactory(decodeNodes);
    }
}
