package org.prgrms.kdtspringvoucher.voucher.service;

import org.prgrms.kdtspringvoucher.voucher.model.Voucher;
import org.prgrms.kdtspringvoucher.voucher.repository.VoucherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
