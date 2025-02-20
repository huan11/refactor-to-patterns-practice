package org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.myWork.Descriptors;

import org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.myWork.Domain.User;

import java.util.Date;

public abstract class AttributeDescriptor {
    private final String descriptorName;
    private final Class<?> mapperType;
    private final Class<?> forType;

    protected AttributeDescriptor(String descriptorName, Class<?> mapperType, Class<?> forType) {
        this.descriptorName = descriptorName;
        this.mapperType = mapperType;
        this.forType = forType;
    }

    /**
     * 1 不需要的参数可以内联 inline parameter
     * 2 方法返回值
     * 3 go to DefaultDescriptor class and use `Use Interface Where Possible`
     */
    public static AttributeDescriptor forInteger(String remoteId, Class<?> descriptorClass) {
        return new DefaultDescriptor(remoteId, descriptorClass, Integer.class);
    }

    public static AttributeDescriptor forDate(String createdDate, Class<?> descriptorClass) {
        return new DefaultDescriptor(createdDate, descriptorClass, Date.class);
    }

    public static AttributeDescriptor forUser(String createdBy, Class<?> descriptorClass) {
        return new ReferenceDescriptor(createdBy, descriptorClass, User.class);
    }

    public String getDescriptorName() {
        return descriptorName;
    }
} 