package com.concurrency.chapter16;

import net.jcip.annotations.NotThreadSafe;
import sun.security.util.Resources;

/**
 * P286 双重检查加锁（不要这么做）
 */
@NotThreadSafe
public class DoubleCheckedLocking {
    private static Resources resources = new Resources();

    public static Resources getInstance() {
        if (resources == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (resources == null) {
                    resources = new Resources();
                }
            }
        }
        return resources;
    }
}
