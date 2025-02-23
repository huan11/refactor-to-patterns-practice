package org.example.refactorings27.Creation6.EncapsulateCompositeWithBuilder.myWork;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;

import static org.junit.jupiter.api.Assertions.*;

public class TagBuilderTest {

    private void assertXmlEquals(String expectedXml, String actualXml) {
        Diff diff = DiffBuilder.compare(expectedXml)
                .withTest(actualXml)
                .ignoreWhitespace()
                .normalizeWhitespace()
                .build();
        assertFalse(diff.hasDifferences(), "XML documents are different: " + diff.toString());
    }

    @Test
    public void testBuildOneNode() {
        String expectedXml = "<flavors/>";
        String actualXml = new TagBuilder("flavors").toXml();
        assertXmlEquals(expectedXml, actualXml);
    }

    @Test
    public void testBuildNodeWithChild() {
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        String expectedXml =
                "<flavors>" +
                        "<flavor/>" +
                "</flavors>";
        assertXmlEquals(expectedXml, builder.toXml());
    }

    @Test
    public void testBuildChildrenOfChildren() {
        String expectedXml =
                "<flavors>" +
                        "<flavor>" +
                                "<requirements>" +
                                        "<requirement/>" +
                                "</requirements>" +
                        "</flavor>" +
                "</flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        builder.addChild("requirements");
        builder.addChild("requirement");
        String actualXml = builder.toXml();
        assertXmlEquals(expectedXml, actualXml);
    }



    @Test
    public void testParents() {
        TagNode root = new TagNode("root");
        assertNull(root.getParent());

        TagNode childNode = new TagNode("child");
        root.add(childNode);
        assertEquals(root, childNode.getParent());
        assertEquals("root", childNode.getParent().getName());
    }

    @Test
    public void testBuildSibling() {
        String expectedXml =
                "<flavors>" +
                        "<flavor1/>" +
                        "<flavor2/>" +
                "</flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor1");
        builder.addSibling("flavor2");
        String actualXml = builder.toXml();
        assertXmlEquals(expectedXml, actualXml);
    }

    @Test
    public void testRepeatingChildrenAndGrandchildren() {
        String expectedXml =
                "<flavors>" +
                        "<flavor>" +
                                "<requirements>" +
                                        "<requirement/>" +
                                "</requirements>" +
                        "</flavor>" +
                        "<flavor>" +
                                "<requirements>" +
                                        "<requirement/>" +
                                "</requirements>" +
                        "</flavor>" +
                "</flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        for (int i=0; i<2; i++) {
            builder.addToParent("flavors", "flavor");
            builder.addChild("requirements");
            builder.addChild("requirement");
        }
        assertXmlEquals(expectedXml, builder.toXml());
    }


    @Test
    public void testParentNameNotFound() {
        TagBuilder builder = new TagBuilder("flavors");
        try {
            for (int i=0; i<2; i++) {
                builder.addToParent("favors", "flavor");
                builder.addChild("requirements");
                builder.addChild("requirement");
            }
            fail("should not allow adding to parent that doesn't exist");
        } catch (RuntimeException e) {
            String expectedErrorMessage = "missing parent tag: favors";
            assertEquals(expectedErrorMessage, e.getMessage());
        }
    }

    @Test
    public void testAttributesAndValues() {
        String expectedXml = 
            "<flavor name='Test-Driven Development'>" +
                "<requirements>" +
                    "<requirement type='hardware'>" +
                        "1 computer for every 2 participants" +
                    "</requirement>" +
                    "<requirement type='software'>" +
                        "IDE" + 
                    "</requirement>" +
                "</requirements>" +
            "</flavor>";

        TagBuilder builder = new TagBuilder("flavor");
        builder.addAttribute("name", "Test-Driven Development");
        builder.addChild("requirements");
        builder.addChild("requirement");
        builder.addAttribute("type", "hardware");
        builder.addValue("1 computer for every 2 participants");
        builder.addToParent("requirements", "requirement");
        builder.addAttribute("type", "software");
        builder.addValue("IDE");

        assertXmlEquals(expectedXml, builder.toXml());
    }

    @Test
    public void testToStringBufferSize() {
        String expected = 
            "<requirements>" +
                "<requirement type='software'>" +
                    "IDE" +
                "</requirement>" +
            "</requirements>";

        TagBuilder builder = new TagBuilder("requirements");
        builder.addChild("requirement");
        builder.addAttribute("type", "software");
        builder.addValue("IDE");

        int stringSize = builder.toXml().length();
        int computedSize = builder.bufferSize();
        assertEquals(stringSize, computedSize);
    }
} 