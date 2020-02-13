package org.lite.spring.factory;

import org.lite.spring.beans.BeanDefinition;

/**
 * Created by bfq on 2020/2/13
 */
public interface BeanFactory {
    Object getBean(String beanID);

    BeanDefinition getBeanDefinition(String petStore);
}
