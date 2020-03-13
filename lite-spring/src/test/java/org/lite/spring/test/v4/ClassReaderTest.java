package org.lite.spring.test.v4;

import jdk.internal.org.objectweb.asm.ClassReader;
import org.junit.Assert;
import org.junit.Test;
import org.lite.spring.core.annotation.AnnotationAttributes;
import org.lite.spring.core.io.ClassPathResource;
import org.lite.spring.core.type.classreading.AnnotationMetadataReadingVisitor;
import org.lite.spring.core.type.classreading.ClassMetadataReadingVisitor;

import java.io.IOException;

/**
 * Created by bfq on 2020/2/29
 */
public class ClassReaderTest {

    @Test
    public void testGetClassMetaData () throws IOException {
        ClassPathResource resource = new ClassPathResource("org/lite/spring/service/v4/PetStoreService.class");
        //jdk自带有ASM，还需要引入spring中的那个asm包吗？
        ClassReader reader = new ClassReader(resource.getInputStream());

        ClassMetadataReadingVisitor visitor = new ClassMetadataReadingVisitor();

        reader.accept(visitor, ClassReader.SKIP_DEBUG);

        Assert.assertFalse(visitor.isAbstract());
        Assert.assertFalse(visitor.isInterface());
        Assert.assertFalse(visitor.isFinal());
        Assert.assertEquals("org.lite.spring.service.v4.PetStoreService", visitor.getClassName());
        Assert.assertEquals("java.lang.Object", visitor.getSuperClassName());
        Assert.assertEquals(0, visitor.getInterfaceNames().length);
    }

    @Test
    public void testGetAnnonation() throws Exception{
        ClassPathResource resource = new ClassPathResource("org/lite/spring/service/v4/PetStoreService.class");
        ClassReader reader = new ClassReader(resource.getInputStream());

        AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor();

        reader.accept(visitor, ClassReader.SKIP_DEBUG);

        String annotation = "org.lite.spring.stereotype.Component";
        Assert.assertTrue(visitor.hasAnnotation(annotation));

        AnnotationAttributes attributes = visitor.getAnnotationAttributes(annotation);

        Assert.assertEquals("petStore", attributes.get("value"));
    }
}
