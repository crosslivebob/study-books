package org.lite.spring.test.v4;

import org.junit.Assert;
import org.junit.Test;
import org.lite.spring.beans.factory.config.DependencyDescriptor;
import org.lite.spring.beans.factory.support.DefaultBeanFactory;
import org.lite.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.lite.spring.core.io.ClassPathResource;
import org.lite.spring.core.io.Resource;
import org.lite.spring.dao.v4.AccountDao;
import org.lite.spring.service.v4.PetStoreService;

import java.lang.reflect.Field;

/**
 * Created by bfq on 2020/3/14
 */
public class DependencyDescriptorTest {

    @Test
    public void testResolveDependency () throws NoSuchFieldException {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource("petstore-v4.xml");
        reader.loadBeanDefinitions(resource);

        Field field = PetStoreService.class.getDeclaredField("accountDao");
        DependencyDescriptor descripter = new DependencyDescriptor(field, true);
        Object o = factory.resolveDependency(descripter);
        Assert.assertTrue(o instanceof AccountDao);
    }
}
