package org.lite.spring.beans.factory.support;

import org.lite.spring.beans.BeanDefinition;
import org.lite.spring.beans.factory.BeanCreationException;
import org.lite.spring.beans.factory.config.ConfigurableBeanFactory;
import org.lite.spring.beans.factory.support.DefaultSingletonBeanRegistry;

/**
 * Created by bfq on 2020/4/12
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
    protected abstract Object createBean(BeanDefinition bd) throws BeanCreationException;
}
