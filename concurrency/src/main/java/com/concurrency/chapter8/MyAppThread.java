package com.concurrency.chapter8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * P146 定制Thread基类
 * 主要是为线程定制一些服务，例如指定线程名字，设置自定义UncaughtExceptionHandler，以及在线程被创建和终止时加入日志
 */
public class MyAppThread extends Thread {
    public static final String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debugLifecycle = true;
    private static final AtomicInteger creadted = new AtomicInteger();
    private static final AtomicInteger aLive = new AtomicInteger();
    private static final Logger log = Logger.getAnonymousLogger();

    public MyAppThread(Runnable r) {
        this(r, DEFAULT_NAME);
    }

    public MyAppThread(Runnable r, String name) {
        super(r, name + "-" + creadted.incrementAndGet());
        setUncaughtExceptionHandler((t, e) -> {
            log.log(Level.SEVERE, "UNCAUGHT int thread " +t.getName(), e);
        });
    }

    @Override
    public void run() {
        // 赋值debug标志以确保一致的值
        boolean debug = debugLifecycle;
        if (debug) {
            log.log(Level.FINE, "Created " + getName());
            try {
                aLive.incrementAndGet();
                super.run();
            } finally {
                aLive.decrementAndGet();
                if (debug) {
                    log.log(Level.FINE, "Exiting " + getName());
                }
            }
        }
    }

    public static int getThreadCreated() {
        return creadted.get();
    }

    public static int getThredAlive() {
        return aLive.get();
    }

    public static boolean getDebug() {
        return debugLifecycle;
    }

    public static void setDebug(boolean b) {
        debugLifecycle = b;
    }
}
