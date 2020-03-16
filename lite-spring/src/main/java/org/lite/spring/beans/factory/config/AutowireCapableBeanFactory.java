package org.lite.spring.beans.factory.config;

import org.lite.spring.beans.factory.BeanFactory;

/**
 * Created by bfq on 2020/3/14
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    public Object resolveDependency(DependencyDescriptor descripter);
}
