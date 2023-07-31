package com.cyl.parten.strategy;

import org.springframework.stereotype.Service;

@Service
public class SvipUser implements SalesStrategy{
    @Override
    public UserType userType() {
        return UserType.SVIP;
    }

    @Override
    public double discount(double fee) {
        return fee * 0.7;
    }
}
