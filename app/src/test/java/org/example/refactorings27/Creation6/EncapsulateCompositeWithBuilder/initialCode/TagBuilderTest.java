package org.example.refactorings27.Creation6.EncapsulateCompositeWithBuilder.initialCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagBuilderTest {
    
    @Test
    public void testBuildOneNode() {
        String expectedXml = "<flavors/>";
        String actualXml = new TagBuilder("flavors").toXml();
        assertEquals(expectedXml, actualXml);
    }

    @Test
    public void testBuildNodeWithChild() {
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        assertEquals("<flavors><flavor></flavor></flavors>", builder.toXml());
    }

    @Test
    public void testBuildNodeWithAttribute() {
        TagBuilder builder = new TagBuilder("flavor");
        builder.addAttribute("name", "vanilla");
        assertEquals("<flavor name='vanilla'></flavor>", builder.toXml());
    }

    @Test
    public void testBuildNodeWithValue() {
        TagBuilder builder = new TagBuilder("flavor");
        builder.addValue("chocolate");
        assertEquals("<flavor>chocolate</flavor>", builder.toXml());
    }
} 