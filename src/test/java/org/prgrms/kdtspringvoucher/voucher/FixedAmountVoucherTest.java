package org.prgrms.kdtspringvoucher.voucher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class FixedAmountVoucherTest {

    @Test
    void discountTest() {
        FixedAmountVoucher fixedAmountVoucher =
                new FixedAmountVoucher(UUID.randomUUID(), 1000);

        long price = 10000;
        long discountedPrice = fixedAmountVoucher.discount(price);

        Assertions.assertEquals(discountedPrice, 9000);
    }

}