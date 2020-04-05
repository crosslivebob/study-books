package org.lite.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * Created by bfq on 2020/4/4
 */
public interface Advice extends MethodInterceptor {
    public Pointcut getPointcut();
}
