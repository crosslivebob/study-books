package org.lite.spring.test.v4;

import org.junit.Assert;
import org.junit.Test;
import org.lite.spring.core.annotation.AnnotationAttributes;
import org.lite.spring.core.io.ClassPathResource;
import org.lite.spring.core.type.AnnotationMetadata;
import org.lite.spring.core.type.classreading.MetadataReader;
import org.lite.spring.core.type.classreading.SimpleMetadataReader;
import org.lite.spring.stereotype.Component;

import java.io.IOException;

public class MetadataReaderTest {
	@Test
	public void testGetMetadata() throws IOException{
		ClassPathResource resource = new ClassPathResource("org/lite/spring/service/v4/PetStoreService.class");
		
		MetadataReader reader = new SimpleMetadataReader(resource);
		//注意：不需要单独使用ClassMetadata
		//ClassMetadata clzMetadata = reader.getClassMetadata();
		AnnotationMetadata amd = reader.getAnnotationMetadata();
		
		String annotation = Component.class.getName();
		
		Assert.assertTrue(amd.hasAnnotation(annotation));		
		AnnotationAttributes attributes = amd.getAnnotationAttributes(annotation);		
		Assert.assertEquals("petStore", attributes.get("value"));
		
		//注：下面对class metadata的测试并不充分
		Assert.assertFalse(amd.isAbstract());		
		Assert.assertFalse(amd.isFinal());
		Assert.assertEquals("org.lite.spring.service.v4.PetStoreService", amd.getClassName());
		
	}
}
