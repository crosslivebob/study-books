package org.lite.spring.context.support;

import org.lite.spring.core.io.Resource;
import org.lite.spring.core.io.support.ClassPathResource;

/**
 * Created by bfq on 2020/2/17
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new ClassPathResource(path);
    }
}
