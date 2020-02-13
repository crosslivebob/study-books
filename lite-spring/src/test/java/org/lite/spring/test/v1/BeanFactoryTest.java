package org.lite.spring.test.v1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.lite.spring.beans.BeanDefinition;
import org.lite.spring.factory.BeanCreationException;
import org.lite.spring.factory.BeanDefinitionStoreException;
import org.lite.spring.factory.BeanFactory;
import org.lite.spring.factory.support.DefaultBeanFactory;
import org.lite.spring.service.v1.PetStoreService;

import static org.junit.Assert.*;

public class BeanFactoryTest {

	@Test
	public void testGetBean() {
		BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
		BeanDefinition bd = factory.getBeanDefinition("petStore");

		assertEquals("org.lite.spring.service.v1.PetStoreService",bd.getBeanClassName());

		PetStoreService petStore = (PetStoreService)factory.getBean("petStore");

		assertNotNull(petStore);
	}

	@Test
	public void testInvalidBean(){

		BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
		try{
			factory.getBean("invalidBean");
		}catch(BeanCreationException e){
			return;
		}
		Assert.fail("expect BeanCreationException ");
	}

	@Test
	public void testInvalidXML(){

		try{
			new DefaultBeanFactory("xxx.xml");
		}catch(BeanDefinitionStoreException e){
			return;
		}
		Assert.fail("expect BeanDefinitionStoreException ");
	}

}
