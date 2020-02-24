package org.lite.spring.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.lite.spring.test.v1.V1AllTest;
import org.lite.spring.test.v2.V2AllTests;

/**
 * Created by bfq on 2020/2/24
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        V1AllTest.class,
        V2AllTests.class
})
public class AllTest {
}
