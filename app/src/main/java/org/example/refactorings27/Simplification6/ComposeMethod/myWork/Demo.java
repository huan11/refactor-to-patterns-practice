package org.example.refactorings27.Simplification6.ComposeMethod.myWork;

public class Demo {
    private final static int GROWTHINCREMENT = 10;
    private boolean readOnly;
    private int size;
    private Object[] elements = new Object[0];

    public void add(Object element) {
        if (readOnly) {
            return;
        }

        if (atCapacity()) {
            grow();
        }

        addElement(element);

    }

    private void addElement(Object element) {
        elements[size++] = element;
    }

    private void grow() {
        Object[] newElements = new Object[elements.length + GROWTHINCREMENT];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    private boolean atCapacity() {
        return size + 1 > elements.length;
    }

    public int getCount() {
        return size;
    }
} 