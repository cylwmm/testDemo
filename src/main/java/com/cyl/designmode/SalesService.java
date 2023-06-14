package com.cyl.designmode;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SalesService {
    Map<UserType, SalesStrategy> map = new HashMap<>();

    public SalesService(List<SalesStrategy> salesStrategyList) {
        salesStrategyList.forEach(it -> map.put(it.userType(), it));
    }

    public double getMount(UserType userType, double fee) {

        return map.get(userType).discount(fee);
    }
}
