package com.cyl.threadLearing;

public class SellTicket implements Runnable {
    static int tickets = 0;

    @Override
    public void run() {
        while (true) {
            if (sell()) break;
        }
    }

    private synchronized static boolean sell() {
        try {
            if (tickets > 100) {
                return true;
            }
            System.out.println(Thread.currentThread().getName() + "出售票@" + tickets);
            Thread.sleep(100);
            tickets++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
