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
//
//    @Test
//    public void testBuildChildrenOfChildren() {
//        String expectedXml =
//                "<flavors>" +
//                        "<flavor>" +
//                                "<requirements>" +
//                                        "<requirement/>" +
//                                "</requirements>" +
//                        "</flavor>" +
//                "</flavors>";
//
//        TagBuilder builder = new TagBuilder("flavors");
//        builder.addChild("flavor");
//        builder.addChild("requirements");
//        builder.addChild("requirement");
//        String actualXml = builder.toXml();
//        assertXmlEquals(expectedXml, actualXml);
//    }
//
//    @Test
//    @Disabled("This test is not implemented yet")
//    public void testBuildSibling() {
//        String expectedXml =
//                "<flavors>" +
//                        "<flavor1/>" +
//                        "<flavor2/>" +
//                "</flavors>";
//
//        TagBuilder builder = new TagBuilder("flavors");
//        builder.addChild("flavor1");
//        builder.addSibling("flavor2");
//        String actualXml = builder.toXml();
//        assertXmlEquals(expectedXml, actualXml);
//    }
//
//    @Test
//    public void testParents() {
//        TagNode root = new TagNode("root");
//        assertNull(root.getParent());
//
//        TagNode childNode = new TagNode("child");
//        root.add(childNode);
//        assertEquals(root, childNode.getParent());
//        assertEquals("root", childNode.getParent().getName());
//    }
} 