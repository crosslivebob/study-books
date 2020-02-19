package org.lite.spring.beans.factory.config;

import org.lite.spring.beans.factory.BeanFactory;

/**
 * Created by bfq on 2020/2/17
 */
public interface ConfigurableBeanFactory extends BeanFactory {
    void setBeanClassLoader(ClassLoader beanClassLoader);
    ClassLoader getBeanClassLoader();
}
