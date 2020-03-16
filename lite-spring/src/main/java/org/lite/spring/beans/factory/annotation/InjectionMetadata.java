package org.lite.spring.beans.factory.annotation;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bfq on 2020/3/14
 */
public class InjectionMetadata {
    private final Class<?> targetClass;
    private List<InjectionElement> injectionElements;

    public InjectionMetadata(Class<?> targetClass, LinkedList<InjectionElement> injectionElements) {
        this.targetClass = targetClass;
        this.injectionElements = injectionElements;
    }

    public List<InjectionElement> getInjectionElements() {
        return injectionElements;
    }

    public void inject(Object target) {
        if (injectionElements == null || injectionElements.isEmpty()) {
            return;
        }
        for (InjectionElement element : injectionElements) {
            element.inject(target);
        }
    }
}
