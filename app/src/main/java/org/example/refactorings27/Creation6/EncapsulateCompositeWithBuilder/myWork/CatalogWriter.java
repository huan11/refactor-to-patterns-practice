package org.example.refactorings27.Creation6.EncapsulateCompositeWithBuilder.myWork;

public class CatalogWriter {
    public String catalogXmlFor(Activity activity) {
        TagNode activityTag = new TagNode("activity");
        
        // Create flavors tag
        TagNode flavorsTag = new TagNode("flavors");
        activityTag.add(flavorsTag);
        
        // Process each flavor
        for (int i = 0; i < activity.getFlavorCount(); i++) {
            TagNode flavorTag = new TagNode("flavor");
            flavorsTag.add(flavorTag);
            
            Flavor flavor = activity.getFlavor(i);
            
            // Process requirements if any exist
            Requirement[] requirements = flavor.getRequirements();
            int requirementsCount = requirements.length;
            
            if (requirementsCount > 0) {
                TagNode requirementsTag = new TagNode("requirements");
                flavorTag.add(requirementsTag);
                
                for (int r = 0; r < requirementsCount; r++) {
                    Requirement requirement = requirements[r];
                    TagNode requirementTag = new TagNode("requirement");
                    requirementTag.addValue(requirement.getName());
                    requirementsTag.add(requirementTag);
                }
            }
        }
        
        return activityTag.toString();
    }
} 