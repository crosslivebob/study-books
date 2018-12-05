package com.concurrency.chapter3;

import java.util.HashMap;
import java.util.Map;

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

    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
//        new ReaderThread().start();
//        number = 42;
//        ready = true;
        Map<String, User> map = new HashMap<String, User>();
        User u1 = new User("Tom", 23);
        User u2 = new User("Sarry", 17);
        map.put("t", u1);
        map.put("s", u2);
        System.out.println(map.get("t"));
        u1.setAge(110);
        System.out.println(map.get("t"));
        User t = map.get("t");
        u1.setAge(90);
        System.out.println(map.get("t"));
    }
}
