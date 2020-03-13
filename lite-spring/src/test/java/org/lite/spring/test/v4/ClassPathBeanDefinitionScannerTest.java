package org.lite.spring.test.v4;

import org.junit.Assert;
import org.junit.Test;
import org.lite.spring.beans.BeanDefinition;
import org.lite.spring.beans.factory.support.DefaultBeanFactory;
import org.lite.spring.context.annotation.ClassPathBeanDefinitionScanner;
import org.lite.spring.context.annotation.ScannedGenericBeanDefinition;
import org.lite.spring.core.annotation.AnnotationAttributes;
import org.lite.spring.core.type.AnnotationMetadata;
import org.lite.spring.stereotype.Component;

public class ClassPathBeanDefinitionScannerTest {
	
	@Test
	public void testParseScanedBean(){
		
		DefaultBeanFactory factory = new DefaultBeanFactory();
		
		String basePackages = "org.lite.spring.service.v4,org.lite.spring.dao.v4";
		
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(factory);
		scanner.doScan(basePackages);
		
		
		String annotation = Component.class.getName();
		
		{
			BeanDefinition bd = factory.getBeanDefinition("petStore");
			Assert.assertTrue(bd instanceof ScannedGenericBeanDefinition);
			ScannedGenericBeanDefinition sbd = (ScannedGenericBeanDefinition)bd;
			AnnotationMetadata amd = sbd.getMetadata();
			
			
			Assert.assertTrue(amd.hasAnnotation(annotation));		
			AnnotationAttributes attributes = amd.getAnnotationAttributes(annotation);		
			Assert.assertEquals("petStore", attributes.get("value"));
		}
		{
			BeanDefinition bd = factory.getBeanDefinition("accountDao");
			Assert.assertTrue(bd instanceof ScannedGenericBeanDefinition);
			ScannedGenericBeanDefinition sbd = (ScannedGenericBeanDefinition)bd;
			AnnotationMetadata amd = sbd.getMetadata();
			Assert.assertTrue(amd.hasAnnotation(annotation));
		}
		{
			BeanDefinition bd = factory.getBeanDefinition("itemDao");
			Assert.assertTrue(bd instanceof ScannedGenericBeanDefinition);
			ScannedGenericBeanDefinition sbd = (ScannedGenericBeanDefinition)bd;
			AnnotationMetadata amd = sbd.getMetadata();
			Assert.assertTrue(amd.hasAnnotation(annotation));
		}
	}
}
