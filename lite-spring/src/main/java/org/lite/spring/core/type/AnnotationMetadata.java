package org.lite.spring.core.type;

import org.lite.spring.core.annotation.AnnotationAttributes;

import java.util.Set;

public interface AnnotationMetadata extends ClassMetadata{
	
	Set<String> getAnnotationTypes();


	boolean hasAnnotation(String annotationType);
	
	public AnnotationAttributes getAnnotationAttributes(String annotationType);
}
