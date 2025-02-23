package org.example.refactorings27.Creation6.EncapsulateCompositeWithBuilder.myWork;

import java.util.ArrayList;
import java.util.List;

public class TagNode {
    private StringBuilder attributes;
    private List<TagNode> children = new ArrayList<>();
    private String name;
    private String value = "";

    public TagNode(String name) {
        this.name = name;
        this.attributes = new StringBuilder();
    }

    public void add(TagNode tagNode) {
        this.children.add(tagNode);
    }

    public void addAttribute(String attribute, String value) {
        this.attributes.append(" ")
                      .append(attribute)
                      .append("='")
                      .append(value)
                      .append("'");
    }

    public void addValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder()
            .append("<")
            .append(this.name)
            .append(this.attributes)
            .append(">");

        for (TagNode tagNode : this.children) {
            result.append(tagNode.toString());
        }

        result.append(this.value)
              .append("</")
              .append(this.name)
              .append(">");
              
        return result.toString();
    }
} 