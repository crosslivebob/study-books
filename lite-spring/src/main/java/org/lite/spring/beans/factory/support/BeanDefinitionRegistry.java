package org.lite.spring.beans.factory.support;

import org.lite.spring.beans.BeanDefinition;

/**
 * Created by bfq on 2020/2/15
 */
public interface BeanDefinitionRegistry {
    BeanDefinition getBeanDefinition(String beanID);
    void registerBeanDefinition(String beanID, BeanDefinition bd);
}
