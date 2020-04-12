package org.lite.spring.aop.aspectj;

import org.aopalliance.intercept.MethodInvocation;
import org.lite.spring.aop.config.AspectInstanceFactory;

import java.lang.reflect.Method;

/**
 * Created by bfq on 2020/4/4
 */
public class AspectJBeforeAdvice extends AbstractAspectJAdvice {
    public AspectJBeforeAdvice(Method adviceMethod,AspectJExpressionPointcut pointcut,AspectInstanceFactory adviceObjectFactory){
        super(adviceMethod,pointcut,adviceObjectFactory);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        this.invokeAdviceMethod();
        Object obj = mi.proceed();
        return obj;
    }
}
