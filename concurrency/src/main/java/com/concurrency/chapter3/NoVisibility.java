package com.concurrency.chapter3;

/**
 * P34 在没有同步情况下共享变量
 * 可能一直保持循环，可能会打印0。
 * 原因：过期数据，读线程检查ready变量时，它可能看到一个过期的值。更坏的情况是，过期既不会发生在全部变量上，也不会完全不出现。
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws Exception {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
