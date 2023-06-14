package com.cyl.designmode;

import org.springframework.stereotype.Service;

@Service
public class NormalUser implements SalesStrategy {
    @Override
    public UserType userType() {
        return UserType.NORMAL;
    }

    @Override
    public double discount(double fee) {
        return fee;
    }
}
