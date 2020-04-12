package org.lite.spring.beans.factory;

import org.lite.spring.aop.Advice;

import java.util.List;

/**
 * Created by bfq on 2020/2/13
 */
public interface BeanFactory {
    Object getBean(String beanID);

    Class<?> getType(String name) throws NoSuchBeanDefinitionException;

    List<Object> getBeansByType(Class<?> type);
}
