package org.prgrms.kdtspringvoucher.voucher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class PercentAmountVoucherTest {

    @Test
    void discountTest() {
        PercentAmountVoucher fixedAmountVoucher =
                new PercentAmountVoucher(UUID.randomUUID(), 10);

        long price = 10000;
        long discountedPrice = fixedAmountVoucher.discount(price);

        Assertions.assertEquals(discountedPrice, 9000);
    }
}