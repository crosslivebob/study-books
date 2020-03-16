package org.lite.spring.beans.factory.config;

import org.lite.spring.beans.factory.BeanFactory;

import java.util.List;

/**
 * Created by bfq on 2020/2/17
 */
public interface ConfigurableBeanFactory extends AutowireCapableBeanFactory {
    void setBeanClassLoader(ClassLoader beanClassLoader);
    ClassLoader getBeanClassLoader();
    void addBeanPostProcessor(BeanPostProcessor postProcessor);
    List<BeanPostProcessor> getBeanPostProcessors();
}
