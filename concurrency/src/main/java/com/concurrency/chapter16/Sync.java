package com.concurrency.chapter16;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * P282 说明如何借助同步的FutureTask的内部类
 */
public class Sync<V> extends AbstractQueuedLongSynchronizer {
    private static final int RUNNING = 1, RAN = 2, CANCELLED = 4;
    private V result;
    private Exception exception;

    void innerSet(V v) {
        while (true) {
            int s = (int) getState();
            if (ranOrCancelled(s)) {
                return;
            }
            if (compareAndSetState(s, RAN)) {
                break;
            }
        }
    }

    V innerGet() throws ExecutionException, InterruptedException {
        acquireInterruptibly(0);
        if (getState() == CANCELLED) {
            throw new CancellationException();
        }
        if (exception != null) {
            throw new ExecutionException(exception);
        }
        return result;
    }

    private boolean ranOrCancelled(int s) {
        return false;
    }
}
