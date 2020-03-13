package org.lite.spring.beans.factory.support;

import org.lite.spring.beans.BeanDefinition;
import org.lite.spring.beans.ConstructorArgument;
import org.lite.spring.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

public class GenericBeanDefinition implements BeanDefinition {
	private String id;
	private String beanClassName;
	private boolean singleton = true;
	private boolean prototype = false;
	private String scope = SCOPE_DEFAULT;
	private List<PropertyValue> propertyValues = new ArrayList<>();
	private ConstructorArgument constructorArgument = new ConstructorArgument();

	public GenericBeanDefinition(String id, String beanClassName) {
		
		this.id = id;
		this.beanClassName = beanClassName;
	}

    public GenericBeanDefinition() {}

	@Override
	public String getBeanClassName() {

		return this.beanClassName;
	}

	public void setBeanClassName(String className){
		this.beanClassName = className;
	}

	@Override
	public boolean isSingleton() {
		return singleton;
	}

	@Override
	public boolean isPrototype() {
		return prototype;
	}

	@Override
	public String getScope() {
		return scope;
	}

	@Override
	public List<PropertyValue> getPropertyValues() {
		return this.propertyValues;
	}

	@Override
	public ConstructorArgument getConstructorArgument() {
		return this.constructorArgument;
	}

	@Override
	public boolean hasConstructorArgumentValues() {
		return !this.constructorArgument.isEmpty();
	}

	@Override
	public String getID() {
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}

	@Override
	public void setScope(String scope) {
		this.scope = scope;
		this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
		this.prototype = SCOPE_PROTOTYPE.equals(scope);
	}

}
