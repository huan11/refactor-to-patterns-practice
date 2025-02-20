package org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.myWork.Descriptors;


public class DefaultDescriptor extends AttributeDescriptor {
    protected DefaultDescriptor(String descriptorName, Class<?> mapperType, Class<?> forType) {
        super(descriptorName, mapperType, forType);
    }
} 