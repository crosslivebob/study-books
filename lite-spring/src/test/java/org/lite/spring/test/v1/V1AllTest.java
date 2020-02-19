package org.lite.spring.test.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by bfq on 2020/2/17
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApplicationContextTest.class,
        BeanFactoryTest.class,
        ResourceTest.class})
public class V1AllTest {
}
