package org.prgrms.kdtspringhomework.voucher.service;

import org.prgrms.kdtspringhomework.command.CreateVoucherStatus;
import org.prgrms.kdtspringhomework.voucher.domain.Voucher;
import org.prgrms.kdtspringhomework.voucher.repository.VoucherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VoucherService {
    private final VoucherRepository voucherRepository;

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public Voucher getVoucher(UUID voucherId) {
        return voucherRepository
                .findById(voucherId)
                .orElseThrow(() -> new RuntimeException(String.format("Can not find a voucher for %s", voucherId)));
    }

    public void addVoucher(String voucherType, long amount) {
        Voucher voucher = CreateVoucherStatus.getVoucher(voucherType, UUID.randomUUID(), amount);
        voucherRepository.add(voucher);
    }

    public List<Voucher> listVouchers() {
        List<Voucher> voucherList = voucherRepository.findAll();
        return voucherList;
    }

    public void useVoucher(Voucher voucher) {
        //강의사용 메소드
    }
}