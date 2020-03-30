package org.lite.spring.beans.factory;

/**
 * Created by bfq on 2020/2/13
 */
public interface BeanFactory {
    Object getBean(String beanID);

    Class<?> getType(String name) throws NoSuchBeanDefinitionException;
}
