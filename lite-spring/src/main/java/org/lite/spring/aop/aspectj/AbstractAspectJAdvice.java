package org.lite.spring.aop.aspectj;

import org.lite.spring.aop.Advice;
import org.lite.spring.aop.Pointcut;

import java.lang.reflect.Method;

/**
 * Created by bfq on 2020/4/4
 */
public abstract class AbstractAspectJAdvice implements Advice {
    protected Method adviceMethod;
    protected AspectJExpressionPointcut pointcut;
    protected Object adviceObject;

    public AbstractAspectJAdvice(Method adviceMethod,
                                 AspectJExpressionPointcut pointcut,
                                 Object adviceObject){

        this.adviceMethod = adviceMethod;
        this.pointcut = pointcut;
        this.adviceObject = adviceObject;
    }

    public void invokeAdviceMethod() throws Throwable {
        //todo 已经验证 ，只适合不带参数的方法，带参数就需要再此类中加上参数元素
        adviceMethod.invoke(adviceObject);
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    public Method getAdviceMethod() {
        return adviceMethod;
    }
}
