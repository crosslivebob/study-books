package org.lite.spring.beans.factory.config;

import org.lite.spring.beans.BeansException;

/**
 * Created by bfq on 2020/3/14
 */
public interface BeanPostProcessor {
    Object beforeInitialization(Object bean, String beanName) throws BeansException;

    Object afterInitialization(Object bean, String beanName) throws BeansException;
}
