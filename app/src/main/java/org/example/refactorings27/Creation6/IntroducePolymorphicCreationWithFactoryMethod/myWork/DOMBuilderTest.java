package org.example.refactorings27.Creation6.IntroducePolymorphicCreationWithFactoryMethod.myWork;

public class DOMBuilderTest extends TestCase {
    private OutputBuilder builder;

    public void testAddAboveRoot() {
        String invalidResult =
            "<orders>" +
                "<order>" +
                "</order>" +
            "</orders>" +
            "<customer>" +
            "</customer>";

        builder = new DOMBuilder("orders");
        builder.addBelow("order");

        try {
            builder.addAbove("customer");
            fail("expecting RuntimeException");
        } catch (RuntimeException ignored) {
        }
    }

    protected void fail(String failureMessage) {
    }
} 