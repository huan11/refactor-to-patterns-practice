package org.example.refactorings27.Creation6.EncapsulateCompositeWithBuilder.myWork;

public class CatalogWriter {
    public String catalogXmlFor(Activity activity) {
        TagBuilder builder = new TagBuilder("activity");
        
        // Create flavors tag
        builder.addChild("flavors");
        
        // Process each flavor
        for (int i = 0; i < activity.getFlavorCount(); i++) {
            builder.addToParent("flavors", "flavor");
            
            Flavor flavor = activity.getFlavor(i);
            
            // Process requirements if any exist
            Requirement[] requirements = flavor.getRequirements();
            int requirementsCount = requirements.length;
            
            if (requirementsCount > 0) {
                builder.addChild("requirements");
                
                for (int r = 0; r < requirementsCount; r++) {
                    Requirement requirement = requirements[r];
                    builder.addToParent("requirements", "requirement");
                }
            }
        }
        
        return builder.toXml();
    }
}