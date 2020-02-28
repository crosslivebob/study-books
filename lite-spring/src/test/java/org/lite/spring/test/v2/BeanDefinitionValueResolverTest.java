package org.lite.spring.test.v2;

import org.junit.Assert;
import org.junit.Test;
import org.lite.spring.beans.PropertyValue;
import org.lite.spring.beans.factory.config.RuntimeBeanReference;
import org.lite.spring.beans.factory.config.TypedStringValue;
import org.lite.spring.beans.factory.support.BeanDefinitionValueResolver;
import org.lite.spring.beans.factory.support.DefaultBeanFactory;
import org.lite.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.lite.spring.core.io.support.ClassPathResource;
import org.lite.spring.dao.v2.AccountDao;

/**
 * Created by bfq on 2020/2/24
 */
public class BeanDefinitionValueResolverTest {
    @Test
    public void testResolveRuntimeBeanReference() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v2.xml"));

        BeanDefinitionValueResolver resolver = new BeanDefinitionValueResolver(factory);
        RuntimeBeanReference reference = new RuntimeBeanReference("accountDao");
        PropertyValue pv = new PropertyValue("accountDao", reference);

        Object value = resolver.resolveValueIfNecessary(pv, reference);

        Assert.assertNotNull(value);
        Assert.assertTrue(value instanceof AccountDao);
    }

    @Test
    public void testResolveTypedStringValue() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v2.xml"));

        BeanDefinitionValueResolver resolver = new BeanDefinitionValueResolver(factory);

        TypedStringValue stringValue = new TypedStringValue("test");
        PropertyValue pv = new PropertyValue("accountDao", stringValue);
        Object value = resolver.resolveValueIfNecessary(pv, stringValue);
        Assert.assertNotNull(value);
        Assert.assertEquals("test", value);
    }
}
