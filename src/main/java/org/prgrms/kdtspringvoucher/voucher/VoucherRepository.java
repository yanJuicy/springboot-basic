package org.prgrms.kdtspringvoucher.voucher;

import java.util.List;

public interface VoucherRepository {

    List<Voucher> findAll();
    void save(Voucher voucher);
}
