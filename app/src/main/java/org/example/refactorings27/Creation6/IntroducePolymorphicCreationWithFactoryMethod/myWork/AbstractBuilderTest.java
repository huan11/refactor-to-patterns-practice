package org.example.refactorings27.Creation6.IntroducePolymorphicCreationWithFactoryMethod.myWork;

public abstract class AbstractBuilderTest extends TestCase {
    protected OutputBuilder builder;

    public void testAddAboveRoot() {
        String invalidResult =
            "<orders>" +
                "<order>" +
                "</order>" +
            "</orders>" +
            "<customer>" +
            "</customer>";

        builder = createBuilder("orders");
        builder.addBelow("order");

        try {
            builder.addAbove("customer");
            fail("expecting RuntimeException");
        } catch (RuntimeException ignored) {
        }
    }

    protected abstract OutputBuilder createBuilder(String orders);

    protected abstract void fail(String failureMessage);
}
