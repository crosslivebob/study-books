package org.lite.spring.beans;

/**
 * Created by bfq on 2020/2/13
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) { super(msg);	}

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
