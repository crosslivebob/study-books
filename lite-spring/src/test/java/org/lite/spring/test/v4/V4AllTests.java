package org.lite.spring.test.v4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by bfq on 2020/3/16
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApplicationContextTestV4.class,
        AutowiredAnnotationProcessorTest.class,
        ClassPathBeanDefinitionScannerTest.class,
        ClassReaderTest.class,
        DependencyDescriptorTest.class,
        InjectionMetadataTest.class,
        MetadataReaderTest.class,
        PackageResourceLoaderTest.class,
        XmlBeanDefinitionReaderTest.class
})
public class V4AllTests {
}
