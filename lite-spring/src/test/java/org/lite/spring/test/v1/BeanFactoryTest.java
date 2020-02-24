package org.lite.spring.test.v1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.lite.spring.beans.BeanDefinition;
import org.lite.spring.core.io.support.ClassPathResource;
import org.lite.spring.beans.factory.BeanCreationException;
import org.lite.spring.beans.factory.BeanDefinitionStoreException;
import org.lite.spring.beans.factory.support.DefaultBeanFactory;
import org.lite.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.lite.spring.service.v1.PetStoreService;

import static org.junit.Assert.*;

public class BeanFactoryTest {

	DefaultBeanFactory factory = null;
	XmlBeanDefinitionReader reader = null;

	@Before
	public void setUp() {
		factory = new DefaultBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
	}

	@Test
	public void testGetBean() {

		reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));

		BeanDefinition bd = factory.getBeanDefinition("petStore");

		assertTrue(bd.isSingleton());
		assertFalse(bd.isPrototype());

		assertEquals(BeanDefinition.SCOPE_DEFAULT, bd.getScope());

		assertEquals("org.lite.spring.service.v1.PetStoreService",bd.getBeanClassName());

		PetStoreService petStore = (PetStoreService)factory.getBean("petStore");

		assertNotNull(petStore);

		PetStoreService petStore1 = (PetStoreService)factory.getBean("petStore");

		assertTrue(petStore.equals(petStore1));
	}

	@Test
	public void testInvalidBean(){

		reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
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
			reader.loadBeanDefinitions(new ClassPathResource("xxx.xml"));
		}catch(BeanDefinitionStoreException e){
			return;
		}
		Assert.fail("expect BeanDefinitionStoreException ");
	}

}
