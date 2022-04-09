package org.prgrms.kdtspringvoucher.voucher.model;

import java.util.UUID;

public interface Voucher {

    UUID getVoucherId();
    long discount(long beforeDiscount);
}
