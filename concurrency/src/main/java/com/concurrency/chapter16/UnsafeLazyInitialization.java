package com.concurrency.chapter16;

import net.jcip.annotations.NotThreadSafe;
import sun.security.util.Resources;

/**
 * P283 不安全的延迟初始化
 */
@NotThreadSafe
public class UnsafeLazyInitialization {
    private static Resources resources;

    public static Resources getInstance() {
        if (resources == null) {
            resources = new Resources();//不安全的发布
        }
        return resources;
    }
}
