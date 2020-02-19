package org.lite.spring.core.io;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by bfq on 2020/2/17
 */
public interface Resource {
    InputStream getInputStream() throws FileNotFoundException;
    String getDescription();
}
