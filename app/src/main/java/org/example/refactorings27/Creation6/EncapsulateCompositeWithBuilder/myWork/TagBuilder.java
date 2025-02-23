package org.example.refactorings27.Creation6.EncapsulateCompositeWithBuilder.myWork;

public class TagBuilder {
    private TagNode rootNode;

    public TagBuilder(String rootTagName) {
        rootNode = new TagNode(rootTagName);
    }

    public String toXml() {
        return rootNode.toString();
    }
}