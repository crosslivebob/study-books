package org.lite.spring.beans.factory.config;

import org.lite.spring.beans.BeansException;

/**
 * Created by bfq on 2020/3/14
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    Object beforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    boolean afterInstantiation(Object bean, String beanName) throws BeansException;

    void postProcessPropertyValues(Object bean, String beanName) throws BeansException;
}
