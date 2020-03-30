package org.lite.spring.aop;

import java.lang.reflect.Method;

/**
 * Created by bfq on 2020/3/27
 */
public interface MethodMatcher {
    boolean matches(Method method1);
}
