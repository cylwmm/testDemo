package com.cyl.designmode;

public interface SalesStrategy {
    public UserType userType();

    public double discount(double fee);
}
