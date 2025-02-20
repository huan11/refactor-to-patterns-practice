package org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.myWork.Descriptors;


public class ReferenceDescriptor extends AttributeDescriptor {
    protected ReferenceDescriptor(String descriptorName, Class<?> mapperType, Class<?> forType) {
        super(descriptorName, mapperType, forType);
    }
} 