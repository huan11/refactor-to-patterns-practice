package org.example.refactorings27.Creation6.IntroducePolymorphicCreationWithFactoryMethod.myWork;

public class DOMBuilder extends OutputBuilder {
    public DOMBuilder(String root) {
    }

    @Override
    public void addAbove(String v) throws RuntimeException {
        super.addAbove(v);
    }
} 