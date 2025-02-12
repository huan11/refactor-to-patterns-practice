package org.example.refactorings27.Utilities3.UnifyInterfaces.initialCode;

public class StringNode extends AbstractNode {
    @Override
    public String toPlainTextString() {
        return "Some text";
    }

    @Override
    public String toHtml() {
        return "<p>Some text</p>";
    }

    @Override
    public String toString() {
        return toPlainTextString();
    }

    @Override
    public int elementBegin() {
        return 0;
    }

    @Override
    public int elementEnd() {
        return 10;
    }


    public void accept(TextExtractor textExtractor) {
        textExtractor.extract(this);
    }
}