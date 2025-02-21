package org.example.refactorings27.Creation6.IntroducePolymorphicCreationWithFactoryMethod.myWork;

public class DOMBuilderTest extends AbstractBuilderTest {
    private OutputBuilder builder;

    protected OutputBuilder createBuilder(String orders) {
        return new DOMBuilder(orders);
    }

    @Override
    protected void fail(String failureMessage) {
    }
} 