package org.lite.spring.context.support;

import org.lite.spring.core.io.Resource;
import org.lite.spring.core.io.support.FileSystemResource;

/**
 * Created by bfq on 2020/2/17
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

    public FileSystemXmlApplicationContext(String path) {
        super(path);
    }

    @Override
    protected Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }

}
