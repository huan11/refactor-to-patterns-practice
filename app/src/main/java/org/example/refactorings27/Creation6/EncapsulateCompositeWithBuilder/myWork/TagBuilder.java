package org.example.refactorings27.Creation6.EncapsulateCompositeWithBuilder.myWork;

public class TagBuilder {
    private TagNode rootNode;
    private TagNode currentNode;

    private int outputBufferSize;
    private static int TAG_CHARS_SIZE= 5;
    private static int ATTRIBUTE_CHARS_SIZE = 4;

    public TagBuilder(String rootTagName) {
        rootNode = new TagNode(rootTagName);
        currentNode = rootNode;
        incrementBufferSizeByTagLength(rootTagName);
    }

    public String toXml() {
        return rootNode.toString();
    }


    // code snippet
//    public String toXml() {
//        StringBuffer xmlResult = new StringBuffer(outputBufferSize);
//        rootNode.appendContentsTo(xmlResult);
//        return xmlResult.toString();
//    }

    public void addChild(String childTagName) {
       addTo(currentNode,childTagName);
    }

    public void addSibling(String siblingTagName) {
        addTo(currentNode.getParent(),siblingTagName);
    }

    private void addTo(TagNode parentNode, String tagName) {
        currentNode = new TagNode(tagName);
        parentNode.add(currentNode);
        incrementBufferSizeByTagLength(tagName);
    }

    public void addToParent(String parentTagName, String childTagName) {
        TagNode parentNode = findParentBy(parentTagName);
        if (parentNode == null)
            throw new RuntimeException("missing parent tag: " + parentTagName);
        addTo(parentNode, childTagName);
    }
    private TagNode findParentBy(String parentName) {
        TagNode parentNode = currentNode;
        while (parentNode != null) {
            if (parentName.equals(parentNode.getName()))
                return parentNode;
            parentNode = parentNode.getParent();
        }
        return null;
    }
    public void addAttribute(String attribute, String value) {
        currentNode.addAttribute(attribute, value);
        incrementBufferSizeByAttributeLength(attribute, value);
    }
    public void addValue(String value) {
        currentNode.addValue(value);
        incrementBufferSizeByValueLength(value);
    }

    public int bufferSize() {
        return outputBufferSize;
    }

    private void incrementBufferSizeByAttributeLength(String name, String value) {
        outputBufferSize += (name.length() + value.length() + ATTRIBUTE_CHARS_SIZE);
    }

    private void incrementBufferSizeByTagLength(String tag) {
        int sizeOfOpenAndCloseTags = tag.length() * 2;
        outputBufferSize += (sizeOfOpenAndCloseTags + TAG_CHARS_SIZE);
    }

    private void incrementBufferSizeByValueLength(String value) {
        outputBufferSize += value.length();
    }
}