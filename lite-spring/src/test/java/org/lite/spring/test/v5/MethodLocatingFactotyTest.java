package org.lite.spring.test.v5;

import org.junit.Assert;
import org.junit.Test;
import org.lite.spring.aop.config.MethodLocatingFactory;
import org.lite.spring.beans.factory.support.DefaultBeanFactory;
import org.lite.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.lite.spring.core.io.ClassPathResource;
import org.lite.spring.core.io.Resource;
import org.lite.spring.tx.TransactionManager;

import java.lang.reflect.Method;

/**
 * Created by bfq on 2020/3/30
 */
public class MethodLocatingFactotyTest {
    @Test
    public void testGetMethod() throws NoSuchMethodException {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        Resource resource = new ClassPathResource("petstore-v5.xml");
        reader.loadBeanDefinitions(resource);

        MethodLocatingFactory methodLocatingFactory = new MethodLocatingFactory();
        methodLocatingFactory.setTargetBeanName("tx");
        methodLocatingFactory.setMethodName("start");
        methodLocatingFactory.setBeanFactorty(beanFactory);

        Method m = methodLocatingFactory.getObject();

        Assert.assertTrue(TransactionManager.class.equals(m.getDeclaringClass()));
        Assert.assertTrue(m.equals(TransactionManager.class.getMethod("start")));
    }
}
