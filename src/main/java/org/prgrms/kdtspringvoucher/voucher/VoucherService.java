package org.prgrms.kdtspringvoucher.voucher;

import java.util.List;

public class VoucherService {

    private final VoucherRepository voucherRepository;

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public List<Voucher> getVouchers() {
        return voucherRepository.findAll();
    }

    public void save(Voucher voucher) {
        voucherRepository.save(voucher);
    }
}
