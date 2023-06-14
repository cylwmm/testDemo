package com.cyl.designmode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SalesServiceTest {

    @Autowired
    SalesService salesService;

    @Test
    public void should_calculate_right() {
        double normal = salesService.getMount(UserType.NORMAL, 100);
        double vip = salesService.getMount(UserType.VIP, 100);
        double svip = salesService.getMount(UserType.SVIP, 100);

        System.out.println("normal:" + normal);
        System.out.println("vip:" + vip);
        System.out.println("svip:" + svip);
    }

}