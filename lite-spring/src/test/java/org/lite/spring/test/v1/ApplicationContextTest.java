package org.lite.spring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.lite.spring.context.ApplicationContext;
import org.lite.spring.context.support.ClassPathXmlApplicationContext;
import org.lite.spring.context.support.FileSystemXmlApplicationContext;
import org.lite.spring.service.v1.PetStoreService;
import org.lite.spring.util.ClassUtils;

/**
 * Created by bfq on 2020/2/17
 */
public class ApplicationContextTest {
    @Test
    public void testGetBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v1.xml");
        PetStoreService petStoreService = (PetStoreService) ctx.getBean("petStore");
        Assert.assertNotNull(petStoreService);
    }

    @Test
    public void testGetBeanFromFileSystemContext() {
        String path = "src\\test\\resources\\petstore-v1.xml";
        ApplicationContext ctx = new FileSystemXmlApplicationContext(path);
        PetStoreService petStoreService = (PetStoreService) ctx.getBean("petStore");
        Assert.assertNotNull(petStoreService);
    }
}
