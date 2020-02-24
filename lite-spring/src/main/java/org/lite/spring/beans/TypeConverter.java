package org.lite.spring.beans;

/**
 * Created by bfq on 2020/2/24
 */
public interface TypeConverter {
    <T> T convertIfNecessary(Object value, Class<T> requiredType);
}
