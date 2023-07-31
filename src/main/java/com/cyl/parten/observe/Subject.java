package com.cyl.parten.observe;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<Observer> observerList = new ArrayList<>();

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    public void nodifyObservers(String newState) {
        observerList.forEach(
            it -> it.update(newState));
    }
}
