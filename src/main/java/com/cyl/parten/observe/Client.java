package com.cyl.parten.observe;

public class Client {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        Observer observer = new ConcerteObserver();
        concreteSubject.attach(observer);
        concreteSubject.change("completed");
    }
}
