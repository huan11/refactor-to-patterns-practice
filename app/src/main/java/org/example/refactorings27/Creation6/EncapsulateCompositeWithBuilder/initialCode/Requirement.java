package org.example.refactorings27.Creation6.EncapsulateCompositeWithBuilder.initialCode;

public class Requirement {
    private String name;
    
    public Requirement(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
} 