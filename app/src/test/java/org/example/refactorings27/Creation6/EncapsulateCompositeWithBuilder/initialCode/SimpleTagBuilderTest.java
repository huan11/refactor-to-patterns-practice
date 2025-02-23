package org.example.refactorings27.Creation6.EncapsulateCompositeWithBuilder.initialCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTagBuilderTest {
    
    @Test
    public void testBuildOneNode() {
        String expectedXml = "<flavors/>";
        String actualXml = new TagBuilder("flavors").toXml();
        assertEquals(expectedXml, actualXml);
    }
} 