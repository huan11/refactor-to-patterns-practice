package org.example.refactorings27.Creation6.IntroducePolymorphicCreationWithFactoryMethod.initialCode;


public class XMLBuilder extends OutputBuilder {
    public XMLBuilder(String root) {
    }

    @Override
    public void addAbove(String v) throws RuntimeException {
        super.addAbove(v);
    }
} 