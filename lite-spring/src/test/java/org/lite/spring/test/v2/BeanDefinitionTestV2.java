package org.lite.spring.test.v2;

import org.junit.Test;
import org.lite.spring.beans.BeanDefinition;
import org.lite.spring.beans.PropertyValue;
import org.lite.spring.beans.factory.config.RuntimeBeanReference;
import org.lite.spring.beans.factory.support.DefaultBeanFactory;
import org.lite.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.lite.spring.core.io.ClassPathResource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by bfq on 2020/2/21
 */
public class BeanDefinitionTestV2 {

    @Test
    public void testGetBeanDefinition() {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v2.xml"));

        BeanDefinition bd = factory.getBeanDefinition("petStore");

        List<PropertyValue> pvs = bd.getPropertyValues();

        assertTrue(pvs.size() ==  4);

        {
            PropertyValue pv = this.getPropertyValue("accountDao", pvs);
            assertNotNull(pv);
            assertTrue(pv.getValue() instanceof RuntimeBeanReference);
        }

        {
            PropertyValue pv = this.getPropertyValue("itemDao", pvs);
            assertNotNull(pv);
            assertTrue(pv.getValue() instanceof RuntimeBeanReference);
        }
    }

    private PropertyValue getPropertyValue(String name, List<PropertyValue> pvs) {
        for (PropertyValue pv : pvs) {
            if (pv.getName().equals(name)) {
                return pv;
            }
        }
        return null;
    }
}
