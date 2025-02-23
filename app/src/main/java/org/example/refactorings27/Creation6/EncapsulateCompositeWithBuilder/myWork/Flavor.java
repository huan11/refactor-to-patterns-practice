package org.example.refactorings27.Creation6.EncapsulateCompositeWithBuilder.myWork;

import java.util.ArrayList;
import java.util.List;

public class Flavor {
    private List<Requirement> requirements = new ArrayList<>();
    
    public Requirement[] getRequirements() {
        return requirements.toArray(new Requirement[0]);
    }
    
    public void addRequirement(Requirement requirement) {
        requirements.add(requirement);
    }
} 