package org.example.refactorings27.Creation6.EncapsulateCompositeWithBuilder.myWork;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TagNode {
    private StringBuilder attributes;
    private List<TagNode> children = new ArrayList<>();
    private String name;
    private String value = "";
    private TagNode parent;
    public TagNode getParent() {
        return parent;
    }

    public void setParent(TagNode parent) {
        this.parent = parent;
    }

    public TagNode(String name) {
        this.name = name;
        this.attributes = new StringBuilder();
    }

    public void add(TagNode childNode) {
        childNode.setParent(this);
        this.children.add(childNode);
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