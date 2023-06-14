package com.cyl.designmode;

import org.springframework.stereotype.Service;

@Service
public class VipUser implements SalesStrategy{
    @Override
    public UserType userType() {
        return UserType.VIP;
    }

    @Override
    public double discount(double fee) {
        return fee * 0.9;
    }
}
