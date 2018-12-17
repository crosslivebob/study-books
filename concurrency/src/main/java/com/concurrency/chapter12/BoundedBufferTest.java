package com.concurrency.chapter12;


import junit.framework.TestCase;

/**
 * P206 BoundedBuffer的基本测试类
 */
public class BoundedBufferTest extends TestCase {

    public void testIsEmptyWhenConstructed() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
        assertTrue(bb.isEmpty());
        assertFalse(bb.isFull());
//        System.out.println(bb.isEmpty());
//        System.out.println(bb.isFull());
    }

    public void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
        for (int i = 0; i < 10; i++) {
            bb.put(i);
        }
        assertTrue(bb.isFull());
        assertFalse(bb.isEmpty());
//        System.out.println(bb.isEmpty());
//        System.out.println(bb.isFull());
    }

    // 测试阻塞行为以及对中断的响应性
    public void testTakeBlocksWhenEmpty() {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        Thread taker = new Thread(() -> {
            try {
                int unused = bb.take();
                fail();//如果执行到这里，那么表现出现了一个错误
            } catch (InterruptedException sucess) {}
        });
        try {
            taker.start();
            Thread.sleep(1000);
            taker.interrupt();
            taker.join(1000);
            assertFalse(taker.isAlive());
        } catch (Exception unexpected) {
            fail();
        }
    }
}
