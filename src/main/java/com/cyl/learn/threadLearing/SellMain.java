package com.cyl.learn.threadLearing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SellMain {
    public static void main(String[] args) {
        SellTicket sellTicket1 = new SellTicket();
        SellTicket sellTicket2 = new SellTicket();
        SellTicket sellTicket3 = new SellTicket();
        SellTicket sellTicket4 = new SellTicket();
//        Thread sellThread1 = new Thread(sellTicket);
//        Thread sellThread2 = new Thread(sellTicket);
//        Thread sellThread4 = new Thread(sellTicket);
//        Thread sellThread5 = new Thread(sellTicket);
//
//        sellThread1.start();
//        sellThread2.start();
//        sellThread4.start();
//        sellThread5.start();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(sellTicket1);
        executorService.submit(sellTicket2);
        executorService.submit(sellTicket3);
        executorService.submit(sellTicket4);
        executorService.shutdown();
    }
}
