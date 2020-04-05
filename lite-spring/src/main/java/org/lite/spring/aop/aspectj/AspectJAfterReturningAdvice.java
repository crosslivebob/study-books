package org.lite.spring.aop.aspectj;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by bfq on 2020/4/4
 */
public class AspectJAfterReturningAdvice extends AbstractAspectJAdvice {
    public AspectJAfterReturningAdvice(Method adviceMethod,AspectJExpressionPointcut pointcut,Object adviceObject){
        super(adviceMethod,pointcut,adviceObject);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = mi.proceed();
        this.invokeAdviceMethod();
        return obj;
    }
}
