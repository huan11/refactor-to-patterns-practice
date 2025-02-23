package org.example.refactorings27.Creation6.EncapsulateCompositeWithBuilder.initialCode;

public class TagBuilder {
    private TagNode rootNode;

    public TagBuilder(String rootName) {
        rootNode = new TagNode(rootName);
    }

    public void addChild(String childName) {
        TagNode child = new TagNode(childName);
        rootNode.add(child);
    }

    public void addAttribute(String name, String value) {
        rootNode.addAttribute(name, value);
    }

    public void addValue(String value) {
        rootNode.addValue(value);
    }

    public String toXml() {
        return rootNode.toString();
    }
} 