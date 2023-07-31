package com.cyl.parten.strategy;

public interface SalesStrategy {
    public UserType userType();

    public double discount(double fee);
}
