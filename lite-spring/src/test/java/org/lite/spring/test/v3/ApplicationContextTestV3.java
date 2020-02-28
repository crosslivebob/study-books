package org.lite.spring.test.v3;

import org.junit.Assert;
import org.junit.Test;
import org.lite.spring.context.ApplicationContext;
import org.lite.spring.context.support.ClassPathXmlApplicationContext;
import org.lite.spring.service.v3.PetStoreService;

/**
 * Created by bfq on 2020/2/27
 */
public class ApplicationContextTestV3 {
    @Test
    public void testGetBeanProperty() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v3.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");

        Assert.assertNotNull(petStore.getAccountDao());
        Assert.assertNotNull(petStore.getItemDao());
        Assert.assertEquals(1, petStore.getVersion());
    }
}
