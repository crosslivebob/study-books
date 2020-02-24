package org.lite.spring.test.v2;

import org.junit.Test;
import org.lite.spring.context.ApplicationContext;
import org.lite.spring.context.support.ClassPathXmlApplicationContext;
import org.lite.spring.dao.v2.AccountDao;
import org.lite.spring.dao.v2.ItemDao;
import org.lite.spring.service.v2.PetStoreService;

import static org.junit.Assert.*;

/**
 * Created by bfq on 2020/2/21
 */
public class ApplicationContextTestV2 {

    @Test
    public void testGetBeanProperty() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v2.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");

        assertNotNull(petStore.getAccountDao());
        assertNotNull(petStore.getItemDao());

        assertTrue(petStore.getAccountDao() instanceof AccountDao);
        assertTrue(petStore.getItemDao() instanceof ItemDao);

        assertEquals("liuxin",petStore.getOwner());
        assertEquals(2, petStore.getVersion());
    }
}
