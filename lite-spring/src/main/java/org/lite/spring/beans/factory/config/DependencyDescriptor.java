package org.lite.spring.beans.factory.config;

import org.lite.spring.util.Assert;

import java.lang.reflect.Field;

/**
 * Created by bfq on 2020/3/14
 */
public class DependencyDescriptor {
    private Field field;
    private boolean required;

    public DependencyDescriptor(Field field, boolean required) {
        Assert.notNull(field, "Field must not null");
        this.field = field;
        this.required = required;
    }

    public Class<?>  getDependencyType() {
        if (this.field != null) {
            return this.field.getType();
        }
        throw new RuntimeException("only support field dependency");
    }

    public boolean isRequired() {
        return required;
    }
}
