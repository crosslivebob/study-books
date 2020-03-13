package org.lite.spring.test.v4;

import org.junit.Assert;
import org.junit.Test;
import org.lite.spring.core.io.Resource;
import org.lite.spring.core.io.support.PackageResourceLoader;

import java.io.IOException;

/**
 * Created by bfq on 2020/2/29
 */
public class PackageResourceLoaderTest {

    @Test
    public void testGetResource() throws IOException {
        PackageResourceLoader loader = new PackageResourceLoader();
        Resource[] resources = loader.getResources("org.lite.spring.dao.v4");
        Assert.assertEquals(2, resources.length);
    }
}
