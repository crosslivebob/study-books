package com.concurrency.chapter16;

import net.jcip.annotations.ThreadSafe;
import sun.security.util.Resources;

/**
 * P286 延长初始化占位类模式
 */
@ThreadSafe
public class ResourceFactory {
    private static class ResourceHolder {
        public static Resources resources = new Resources();
    }

    public static Resources getResource() {
        return ResourceHolder.resources;
    }
}
