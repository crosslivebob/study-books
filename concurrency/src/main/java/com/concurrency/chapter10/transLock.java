package com.concurrency.chapter10;

import javax.naming.InsufficientResourcesException;

/**
 * P172
 * 通过锁顺序来避免死锁
 * 使用System.identityHashCode来定义锁的顺序
 */
public class transLock {
    private static final Object tieLock = new Object();

    public void transferMoney(final Account fromAcct, final Account toAcct, final double amount) throws InsufficientResourcesException {
        class Helper {
            public void transfer() throws InsufficientResourcesException {
                if (fromAcct.getBalance() - amount < 0) {
                    throw new InsufficientResourcesException();
                } else {
                    fromAcct.debit(amount);
                    toAcct.credit(amount);
                }
            }
        }
        int fromHash = System.identityHashCode(fromAcct);
        int toHash = System.identityHashCode(toAcct);

        if (fromHash < toHash) {
            synchronized (fromAcct) {
                synchronized (toAcct) {
                    new Helper().transfer();
                }
            }
        } else if (fromHash > toHash) {
            synchronized (toAcct) {
                synchronized (fromAcct) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAcct) {
                    synchronized (toAcct) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }
}

class Account{
    public double getBalance() {
        return 0;
    }

    public void debit(double amount) {
    }

    public void credit(double amount) {
    }
}
