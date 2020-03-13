package org.lite.spring.context.annotation;

import org.lite.spring.beans.factory.annotation.AnnotatedBeanDefinition;
import org.lite.spring.beans.factory.support.GenericBeanDefinition;
import org.lite.spring.core.type.AnnotationMetadata;

public class ScannedGenericBeanDefinition extends GenericBeanDefinition implements AnnotatedBeanDefinition {

	private final AnnotationMetadata metadata;


	public ScannedGenericBeanDefinition(AnnotationMetadata metadata) {
		super();
		
		this.metadata = metadata;
		
		setBeanClassName(this.metadata.getClassName());
	}


	@Override
	public final AnnotationMetadata getMetadata() {
		return this.metadata;
	}

}