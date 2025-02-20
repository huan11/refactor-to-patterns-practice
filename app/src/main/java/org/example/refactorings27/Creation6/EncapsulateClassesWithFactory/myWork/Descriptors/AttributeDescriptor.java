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

    /**
     * 1 不需要的参数可以内联 inline parameter
     * 2 方法返回值
     * 3 go to DefaultDescriptor class and use `Use Interface Where Possible`
     */
    public static AttributeDescriptor forInteger(String remoteId, Class<?> descriptorClass) {
        return new DefaultDescriptor(remoteId, descriptorClass, Integer.class);
    }

    public String getDescriptorName() {
        return descriptorName;
    }
} 