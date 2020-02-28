package org.lite.spring.beans.factory.support;

import org.lite.spring.beans.PropertyValue;
import org.lite.spring.beans.factory.BeanFactory;
import org.lite.spring.beans.factory.config.RuntimeBeanReference;
import org.lite.spring.beans.factory.config.TypedStringValue;

/**
 * Created by bfq on 2020/2/24
 */
public class BeanDefinitionValueResolver {
    private final BeanFactory beanFactory;

    public BeanDefinitionValueResolver(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object resolveValueIfNecessary(PropertyValue pv, Object value) {
        if (value instanceof RuntimeBeanReference) {
            RuntimeBeanReference ref = (RuntimeBeanReference) value;
            String refName = ref.getBeanName();
            Object bean = this.beanFactory.getBean(refName);
            if (pv != null) {
                pv.setConvertedValue(value);
            }
            return bean;
        } else if (value instanceof TypedStringValue) {
            return ((TypedStringValue) value).getValue();
        } else {
            //TODO
            throw new RuntimeException("the value " + value +" has not implemented");
        }
    }

    public Object resolveValueIfNecessary(Object value) {
        return resolveValueIfNecessary(null, value);
    }
}
