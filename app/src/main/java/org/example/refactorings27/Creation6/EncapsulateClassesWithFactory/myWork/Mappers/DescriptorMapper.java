package org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.myWork.Mappers;

import org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.myWork.Descriptors.AttributeDescriptor;
import org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.myWork.Descriptors.DefaultDescriptor;
import org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.myWork.Descriptors.ReferenceDescriptor;
import org.example.refactorings27.Creation6.EncapsulateClassesWithFactory.myWork.Domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DescriptorMapper {
    protected List<AttributeDescriptor> createAttributeDescriptors() {
        List<AttributeDescriptor> result = new ArrayList<>();

        /** 提取方法 练习
         * 对参数先 extract variable，不是hardcode
         * 然后 extract method，这样可以保证函数有参数
         * 最后 inline variable
         */

        result.add(AttributeDescriptor.forInteger("remoteId", getDescriptorClass()));
        result.add(new DefaultDescriptor("createdDate", getDescriptorClass(), Date.class));
        result.add(new DefaultDescriptor("lastChangedDate", getDescriptorClass(), Date.class));
        result.add(new ReferenceDescriptor("createdBy", getDescriptorClass(), User.class));
        result.add(new ReferenceDescriptor("lastChangedBy", getDescriptorClass(), User.class));
        //result.add(new DefaultDescriptor("optimisticLockVersion", getDescriptorClass(), Integer.class));
        result.add(AttributeDescriptor.forInteger("optimisticLockVersion", getDescriptorClass()));
        return result;
    }

    private Class<?> getDescriptorClass() {
        return DescriptorMapper.class;
    }
    public void test(){

    }
} 