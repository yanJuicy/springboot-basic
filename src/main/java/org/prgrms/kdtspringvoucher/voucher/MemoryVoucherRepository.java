package org.prgrms.kdtspringvoucher.voucher;

import java.util.ArrayList;
import java.util.List;

public class MemoryVoucherRepository implements VoucherRepository {

    private static final List<Voucher> voucherList = new ArrayList<>();

    @Override
    public List<Voucher> findAll() {
        return voucherList;
    }

    @Override
    public void save(Voucher voucher) {
        voucherList.add(voucher);
    }
}
