package org.example.refactorings27.Utilities3.UnifyInterfaces.initialCode;

public abstract class AbstractNode {
    public abstract String toPlainTextString();
    public abstract String toHtml();
    public abstract String toString();
    public abstract int elementBegin();
    public abstract int elementEnd();
}