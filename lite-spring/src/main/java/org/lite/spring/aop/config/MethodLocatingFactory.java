package org.lite.spring.aop.config;

import org.lite.spring.beans.BeanUtils;
import org.lite.spring.beans.factory.BeanFactory;
import org.lite.spring.util.StringUtils;

import java.lang.reflect.Method;

/**
 * Created by bfq on 2020/3/30
 */
public class MethodLocatingFactory {

    private String targerBeanName;
    private String methodName;
    private Method method;

    public void setTargetBeanName(String targerBeanName) {
        this.targerBeanName = targerBeanName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setBeanFactorty(BeanFactory beanFactory) {
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

    public Method getObject() {
        return this.method;
    }
}
