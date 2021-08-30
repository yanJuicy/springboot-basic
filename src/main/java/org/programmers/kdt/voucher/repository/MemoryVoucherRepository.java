package org.programmers.kdt.voucher.repository;

import org.programmers.kdt.voucher.Voucher;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Profile("test")
public class MemoryVoucherRepository implements VoucherRepository {
    private final Map<UUID, Voucher> repository = new ConcurrentHashMap<UUID, Voucher>();

    @Override
    public Optional<Voucher> findById(UUID voucherId) {
        return Optional.ofNullable(repository.get(voucherId));
    }

    @Override
    public Voucher insert(Voucher voucher) {
        return repository.put(voucher.getVoucherId(), voucher);
    }

    @Override
    public Optional<Voucher> deleteVoucher(UUID voucherId) {
        return Optional.ofNullable(repository.remove(voucherId));
    }

    @Override
    public List<Voucher> findAll() {
        return new ArrayList<>(repository.values());
    }
}