package com.cyl.parten.observe;

public class ConcerteObserver implements Observer {
    @Override
    public void update(String state) {
        System.out.println("observer state changed to :" + state);
    }
}