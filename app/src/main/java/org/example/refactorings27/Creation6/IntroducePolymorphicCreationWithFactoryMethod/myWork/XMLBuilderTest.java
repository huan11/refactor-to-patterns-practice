package org.example.refactorings27.Creation6.IntroducePolymorphicCreationWithFactoryMethod.myWork;


public class XMLBuilderTest extends AbstractBuilderTest {

    protected OutputBuilder createBuilder(String orders) {
        return new XMLBuilder(orders);
    }

    protected void fail(String failureMessage) {
    }
} 