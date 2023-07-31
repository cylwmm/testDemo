package com.cyl.learn.threadLearing;

public class TestThread extends Thread{
    public static void main(String[] args) {
        TestThread t1 = new TestThread();
        t1.start();
        TestThread t2 = new TestThread();
        t2.start();

    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("hello word : " + Thread.currentThread().getName() );
        }
    }
}
