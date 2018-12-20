package com.concurrency.chapter14;

import net.jcip.annotations.ThreadSafe;

/**
 * P240 当不满足前提条件时，有界缓存不会执行相应的操作
 */
@ThreadSafe
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    public GrumpyBoundedBuffer(int size) {
        super(size);
    }

    public synchronized void put(V v) throws Exception {
        if (isFull()) {
            throw new RuntimeException();
        }
    }

    public synchronized V take() throws Exception {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return doTake();
    }
}
