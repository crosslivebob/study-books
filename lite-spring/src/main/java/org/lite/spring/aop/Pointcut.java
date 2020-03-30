package org.lite.spring.aop;

/**
 * Created by bfq on 2020/3/30
 */
public interface Pointcut {
    MethodMatcher getMethodMatcher();
    String getExpression();
}
