package org.lite.spring.beans.factory;

/**
 * Created by bfq on 2020/4/10
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();
}
