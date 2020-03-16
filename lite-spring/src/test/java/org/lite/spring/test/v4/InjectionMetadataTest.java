package org.lite.spring.test.v4;

import org.junit.Assert;
import org.junit.Test;
import org.lite.spring.beans.factory.annotation.AutowiredFieldElement;
import org.lite.spring.beans.factory.annotation.InjectionElement;
import org.lite.spring.beans.factory.annotation.InjectionMetadata;
import org.lite.spring.beans.factory.support.DefaultBeanFactory;
import org.lite.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.lite.spring.core.io.ClassPathResource;
import org.lite.spring.core.io.Resource;
import org.lite.spring.dao.v4.AccountDao;
import org.lite.spring.dao.v4.ItemDao;
import org.lite.spring.service.v4.PetStoreService;

import java.lang.reflect.Field;
import java.util.LinkedList;

/**
 * Created by bfq on 2020/3/14
 */
public class InjectionMetadataTest {

    @Test
    public void testInjection() throws Exception {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource("petstore-v4.xml");
        reader.loadBeanDefinitions(resource);

        Class<?> clz = PetStoreService.class;
        LinkedList<InjectionElement> elements = new LinkedList<>();

        {
            Field f = PetStoreService.class.getDeclaredField("accountDao");
            InjectionElement injectionElement = new AutowiredFieldElement(f,true,factory);
            elements.add(injectionElement);
        }

        {
            Field f = PetStoreService.class.getDeclaredField("itemDao");
            InjectionElement injectionElem = new AutowiredFieldElement(f,true,factory);
            elements.add(injectionElem);
        }

        InjectionMetadata metaData = new InjectionMetadata(clz, elements);

        PetStoreService petStore = new PetStoreService();
        metaData.inject(petStore);

        Assert.assertTrue(petStore.getAccountDao() instanceof AccountDao);

        Assert.assertTrue(petStore.getItemDao() instanceof ItemDao);

    }
}
