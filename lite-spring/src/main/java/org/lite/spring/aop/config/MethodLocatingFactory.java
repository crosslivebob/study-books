package org.lite.spring.aop.config;

import org.lite.spring.beans.BeanUtils;
import org.lite.spring.beans.BeansException;
import org.lite.spring.beans.factory.BeanFactory;
import org.lite.spring.beans.factory.BeanFactoryAware;
import org.lite.spring.beans.factory.FactoryBean;
import org.lite.spring.util.StringUtils;

import java.lang.reflect.Method;

/**
 * Created by bfq on 2020/3/30
 */
public class MethodLocatingFactory implements FactoryBean<Method>, BeanFactoryAware {

    private String targerBeanName;
    private String methodName;
    private Method method;

    public void setTargetBeanName(String targerBeanName) {
        this.targerBeanName = targerBeanName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        if (!StringUtils.hasText(this.targerBeanName)) {
            throw new IllegalArgumentException("Property 'targetBeanName' is required");
        }
        if (!StringUtils.hasText(this.methodName)) {
            throw new IllegalArgumentException("Property 'methodName' is required");
        }

        Class<?> beanClass = beanFactory.getType(this.targerBeanName);
        if (beanClass == null) {
            throw new IllegalArgumentException("Can't determine type of bean with name '" + this.targerBeanName + "'");
        }

        this.method = BeanUtils.resolveSignature(this.methodName, beanClass);

        if (this.method == null) {
            throw new IllegalArgumentException("Unable to locate method [" + this.methodName + "] on  bean ["
                    + this.targerBeanName + "]");
        }
    }

    @Override
    public Method getObject() {
        return this.method;
    }

    @Override
    public Class<?> getObjectType() {
        return Method.class;
    }
}
