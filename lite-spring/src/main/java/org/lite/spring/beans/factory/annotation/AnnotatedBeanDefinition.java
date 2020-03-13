package org.lite.spring.beans.factory.annotation;

import org.lite.spring.beans.BeanDefinition;
import org.lite.spring.core.type.AnnotationMetadata;

public interface AnnotatedBeanDefinition extends BeanDefinition {
	AnnotationMetadata getMetadata();
}
