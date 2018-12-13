package com.concurrency.chapter8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * P146 自定义的线程工厂
 * 每当线程池需要创建一个新线程时都会调用newThread方法。
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new MyAppThread(r, poolName);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor(new MyThreadFactory("Test"));
        service.execute(() -> {
            System.out.println("Yes， this is a test!!!!");
        });
        service.shutdown();
    }
}
