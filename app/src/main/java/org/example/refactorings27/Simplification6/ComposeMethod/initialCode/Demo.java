package org.example.refactorings27.Simplification6.ComposeMethod.initialCode;

public class Demo {
    private boolean readOnly;
    private int size;
    private Object[] elements = new Object[0];

    public void add(Object element) {
        if (!readOnly) {
            int newSize = size + 1;

            if (newSize > elements.length) {
                Object[] newElements = new Object[elements.length + 10];

                for (int i = 0; i < size; i++) {
                    newElements[i] = elements[i];
                }

                elements = newElements;
            }

            elements[size++] = element;
        }
    }

    public int getCount() {
        return size;
    }
} 