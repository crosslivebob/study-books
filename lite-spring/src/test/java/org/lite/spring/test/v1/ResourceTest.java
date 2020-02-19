package org.lite.spring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.lite.spring.core.io.Resource;
import org.lite.spring.core.io.support.ClassPathResource;
import org.lite.spring.core.io.support.FileSystemResource;
import org.lite.spring.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bfq on 2020/2/17
 */
public class ResourceTest {

    @Test
    public void testClassPathResource () {
        Resource resource = new ClassPathResource("petstore-v1.xml");
        try(InputStream is = resource.getInputStream()) {
            //注意 这个测试并不充分！！
            Assert.assertNotNull(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileSystemResource () {
        String path = "src\\test\\resources\\petstore-v1.xml";
        Resource resource = new FileSystemResource(path);
        try(InputStream is = resource.getInputStream()) {
            //注意 这个测试并不充分！！
            Assert.assertNotNull(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
