package org.lite.spring.aop.aspectj;

import org.aopalliance.intercept.MethodInvocation;
import org.lite.spring.aop.config.AspectInstanceFactory;

import java.lang.reflect.Method;

/**
 * Created by bfq on 2020/4/4
 */
public class AspectJAfterThrowingAdvice extends AbstractAspectJAdvice {
    public AspectJAfterThrowingAdvice(Method adviceMethod, AspectJExpressionPointcut pointcut, AspectInstanceFactory adviceObjectFactory) {
        super(adviceMethod, pointcut, adviceObjectFactory);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        try {
            return mi.proceed();
        } catch (Throwable t) {
            this.invokeAdviceMethod();
            throw t;
        }
    }
}
