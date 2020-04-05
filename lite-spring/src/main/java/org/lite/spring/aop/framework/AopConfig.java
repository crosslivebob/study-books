package org.lite.spring.aop.framework;

import org.lite.spring.aop.Advice;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by bfq on 2020/4/5
 */
public interface AopConfig {
    Class<?> getTargetClass();

    Object getTargetObject();

    boolean isProxyTargetClass();

    Class<?>[] getProxiedInterfaces();

    boolean isInterfaceProxied(Class<?> intf);

    List<Advice> getAdvices();

    void addAdvice(Advice advice);

    List<Advice> getAdvices(Method method/*, Class<?> targetClass*/);

    void setTargetObject(Object obj);
}
