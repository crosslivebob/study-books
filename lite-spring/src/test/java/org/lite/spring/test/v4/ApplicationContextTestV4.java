package org.lite.spring.test.v4;

import org.junit.Assert;
import org.junit.Test;
import org.lite.spring.context.ApplicationContext;
import org.lite.spring.context.support.ClassPathXmlApplicationContext;
import org.lite.spring.service.v4.PetStoreService;

/**
 * Created by bfq on 2020/2/29
 */
public class ApplicationContextTestV4 {

    @Test
    public void testGetBeanProperty () {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v4.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");

        Assert.assertNotNull(petStore.getAccountDao());
        Assert.assertNotNull(petStore.getItemDao());
    }
}
