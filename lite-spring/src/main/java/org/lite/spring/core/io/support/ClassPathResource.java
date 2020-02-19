package org.lite.spring.core.io.support;

import org.lite.spring.core.io.Resource;
import org.lite.spring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by bfq on 2020/2/17
 */
public class ClassPathResource implements Resource {
    private String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader == null ? ClassUtils.getDefaultClassLoader() : classLoader;
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        InputStream inputStream = this.classLoader.getResourceAsStream(this.path);

        if (inputStream == null) {
            throw new FileNotFoundException(this.path + " cannot be opened");
        }
        return inputStream;
    }

    @Override
    public String getDescription() {
        return this.path;
    }
}
