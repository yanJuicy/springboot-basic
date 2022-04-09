package org.prgrms.kdtspringvoucher.voucher.repository;

import org.prgrms.kdtspringvoucher.voucher.model.Voucher;

import java.util.List;

public interface VoucherRepository {

    List<Voucher> findAll();
    void save(Voucher voucher);
}
