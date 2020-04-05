package org.lite.spring.aop.framework;

/**
 * Created by bfq on 2020/4/5
 */
@SuppressWarnings("serial")
public class AopConfigException extends RuntimeException  {
    /**
     * Constructor for AopConfigException.
     * @param msg the detail message
     */
    public AopConfigException(String msg) {
        super(msg);
    }
    /**
     * Constructor for AopConfigException.
     * @param msg the detail message
     * @param cause the root cause
     */
    public AopConfigException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
