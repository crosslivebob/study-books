package org.lite.spring.beans;

import java.util.List;

/**
 * Created by bfq on 2020/2/13
 */
public interface BeanDefinition {
    public static final String SCOPE_SINGLETON = "single";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT = "";

    public String getBeanClassName();

    public boolean isSingleton();

    public boolean isPrototype();

    String getScope();
    void setScope(String scope);

    public List<PropertyValue> getPropertyValues();

    public ConstructorArgument getConstructorArgument();
    public boolean hasConstructorArgumentValues();

    public String getID();

    public Class<?> getBeanClass()throws IllegalStateException ;
    public boolean hasBeanClass();
    public Class<?> resolveBeanClass(ClassLoader classLoader) throws ClassNotFoundException;;
}
