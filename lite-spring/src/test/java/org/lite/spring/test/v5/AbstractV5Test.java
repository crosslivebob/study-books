package org.lite.spring.test.v5;

import org.lite.spring.aop.config.AspectInstanceFactory;
import org.lite.spring.beans.factory.BeanFactory;
import org.lite.spring.beans.factory.support.DefaultBeanFactory;
import org.lite.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.lite.spring.core.io.ClassPathResource;
import org.lite.spring.core.io.Resource;
import org.lite.spring.tx.TransactionManager;

import java.lang.reflect.Method;

/**
 * Created by bfq on 2020/4/10
 */
public class AbstractV5Test {

    protected BeanFactory getBeanFactory(String configFile) {
        DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultBeanFactory);
        Resource resource = new ClassPathResource(configFile);
        reader.loadBeanDefinitions(resource);
        return defaultBeanFactory;
    }

    protected Method getAdviceMethod(String methodName) throws Exception {
        return TransactionManager.class.getMethod(methodName);
    }

    protected AspectInstanceFactory getAspectInstanceFactory(String targetBeanName) {
        AspectInstanceFactory factory = new AspectInstanceFactory();
        factory.setAspectBeanName(targetBeanName);
        return factory;
    }
}
