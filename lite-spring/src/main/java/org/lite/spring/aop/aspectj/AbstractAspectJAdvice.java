package org.lite.spring.aop.aspectj;

import org.lite.spring.aop.Advice;
import org.lite.spring.aop.Pointcut;
import org.lite.spring.aop.config.AspectInstanceFactory;

import java.lang.reflect.Method;

/**
 * Created by bfq on 2020/4/4
 */
public abstract class AbstractAspectJAdvice implements Advice {
    protected Method adviceMethod;
    protected AspectJExpressionPointcut pointcut;
    protected AspectInstanceFactory adviceObjectFactory;

    public AbstractAspectJAdvice(Method adviceMethod,
                                 AspectJExpressionPointcut pointcut,
                                 AspectInstanceFactory adviceObjectFactory){

        this.adviceMethod = adviceMethod;
        this.pointcut = pointcut;
        this.adviceObjectFactory = adviceObjectFactory;
    }

    public void invokeAdviceMethod() throws Throwable {
        //todo 已经验证 ，只适合不带参数的方法，带参数就需要再此类中加上参数元素
        adviceMethod.invoke(adviceObjectFactory.getAspectInstance());
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    public Method getAdviceMethod() {
        return adviceMethod;
    }

    public Object getAdviceInstance() throws Exception {
        return this.adviceObjectFactory.getAspectInstance();
    }
}
