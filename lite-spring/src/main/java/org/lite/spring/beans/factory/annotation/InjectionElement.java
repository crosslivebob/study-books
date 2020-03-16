package org.lite.spring.beans.factory.annotation;

import org.lite.spring.beans.factory.config.AutowireCapableBeanFactory;

import java.lang.reflect.Member;

/**
 * Created by bfq on 2020/3/14
 */
public abstract class InjectionElement {
    protected Member member;
    protected AutowireCapableBeanFactory factory;
    InjectionElement(Member member, AutowireCapableBeanFactory factory) {
        this.member = member;
        this.factory = factory;
    }

    public abstract void inject(Object target);
}
