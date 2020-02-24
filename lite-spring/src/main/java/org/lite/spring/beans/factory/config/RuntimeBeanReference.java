package org.lite.spring.beans.factory.config;

/**
 * Created by bfq on 2020/2/21
 */
public class RuntimeBeanReference {
    private final String beanName;
    public RuntimeBeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return this.beanName;
    }
}
