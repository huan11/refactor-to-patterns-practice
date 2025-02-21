package org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.initialCode.Mappers;

import org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.initialCode.Descriptors.AttributeDescriptor;
import org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.initialCode.Descriptors.DefaultDescriptor;
import org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.initialCode.Descriptors.ReferenceDescriptor;
import org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.initialCode.Domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class DescriptorMapper {
    protected List<AttributeDescriptor> createAttributeDescriptors() {
        List<AttributeDescriptor> result = new ArrayList<>();

        result.add(new DefaultDescriptor("remoteId", getDescriptorClass(), Integer.class));
        result.add(new DefaultDescriptor("createdDate", getDescriptorClass(), Date.class));
        result.add(new DefaultDescriptor("lastChangedDate", getDescriptorClass(), Date.class));
        result.add(new ReferenceDescriptor("createdBy", getDescriptorClass(), User.class));
        result.add(new ReferenceDescriptor("lastChangedBy", getDescriptorClass(), User.class));
        result.add(new DefaultDescriptor("optimisticLockVersion", getDescriptorClass(), Integer.class));
        return result;
    }

    private Class<?> getDescriptorClass() {
        return DescriptorMapper.class;
    }
} 