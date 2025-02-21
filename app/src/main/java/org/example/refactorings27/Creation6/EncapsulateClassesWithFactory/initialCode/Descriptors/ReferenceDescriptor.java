package org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.initialCode.Descriptors;


public class ReferenceDescriptor extends AttributeDescriptor {
    public ReferenceDescriptor(String descriptorName, Class<?> mapperType, Class<?> forType) {
        super(descriptorName, mapperType, forType);
    }
} 