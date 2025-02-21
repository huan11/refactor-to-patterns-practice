package org.example.refactorings27.Creation6.IntroducePolymorphicCreationWithFactoryMethod.myWork;

public class OutputBuilder {
    public void addBelow(String v) {
    }

    public void addAbove(String v) throws RuntimeException {
        throw new RuntimeException("Cannot add above root element");
    }
} 