package org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.myWork.Descriptors;

public abstract class AttributeDescriptor {
    private final String descriptorName;
    private final Class<?> mapperType;
    private final Class<?> forType;

    protected AttributeDescriptor(String descriptorName, Class<?> mapperType, Class<?> forType) {
        this.descriptorName = descriptorName;
        this.mapperType = mapperType;
        this.forType = forType;
    }

    public String getDescriptorName() {
        return descriptorName;
    }
} 