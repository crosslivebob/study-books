package org.lite.spring.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by bfq on 2020/4/4
 */
public class ReflectiveMethodInvocation implements MethodInvocation {
    protected final Object targetObject; //petStoreService
    protected final Method targetMethod; //placeOrder方法

    private Object[] arguments;

    /**
     * List of MethodInterceptor
     */
    private final List<MethodInterceptor> interceptors;

    /**
     * Index from 0 of the current interceptor we're invoking.
     * -1 until we invoke: then the current interceptor.
     */
    private int currentInterceptorIndex = -1;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments,
                                      List<MethodInterceptor> interceptors) {
        this.targetObject = target;
        this.targetMethod = method;
        this.arguments = arguments;
        this.interceptors = interceptors;
    }

    /**
     * Return the method invoked on the proxied interface.
     * May or may not correspond with a method invoked on an underlying
     * implementation of that interface.
     */
    @Override
    public Method getMethod() {
        return this.targetMethod;
    }

    @Override
    public Object[] getArguments() {
        return this.arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        //所有拦截器已经调用完毕
        if (currentInterceptorIndex == interceptors.size() - 1) {
            return invokeJoinpoint();
        }
        currentInterceptorIndex++;

        MethodInterceptor interceptor = this.interceptors.get(currentInterceptorIndex);
        return interceptor.invoke(this);
    }

    @Override
    public Object getThis() {
        return this.targetObject;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return this.targetMethod;
    }

    /**
     * Invoke the joinpoint using reflection.
     * Subclasses can override this to use custom invocation.
     * @return the return value of the joinpoint
     * @throws Throwable if invoking the joinpoint resulted in an exception
     */
    protected Object invokeJoinpoint() throws Throwable {
        return this.targetMethod.invoke(this.targetObject, this.arguments);
    }
}
