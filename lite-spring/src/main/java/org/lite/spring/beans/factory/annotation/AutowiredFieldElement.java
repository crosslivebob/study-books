package org.lite.spring.beans.factory.annotation;

import org.lite.spring.beans.factory.config.AutowireCapableBeanFactory;
import org.lite.spring.beans.factory.config.DependencyDescriptor;
import org.lite.spring.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by bfq on 2020/3/14
 */
public class AutowiredFieldElement extends InjectionElement {
    boolean required;

    public AutowiredFieldElement(Field f, boolean required, AutowireCapableBeanFactory factory) {
        super(f, factory);
        this.required = required;
    }

    public Field getField(){
        return (Field)this.member;
    }

    @Override
    public void inject(Object target) {
        Field field = this.getField();
        try {
            DependencyDescriptor desc = new DependencyDescriptor(field, this.required);
            Object value = factory.resolveDependency(desc);

            if (value != null) {
                ReflectionUtils.makeAccessible(field);
                field.set(target, value);
            }
        } catch (Throwable ex) {
            throw new RuntimeException("Could not autowire field : " + field, ex);
        }
    }
}
